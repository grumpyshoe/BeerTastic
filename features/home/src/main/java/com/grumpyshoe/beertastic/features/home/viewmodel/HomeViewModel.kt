package com.grumpyshoe.beertastic.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeerById
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeers
import com.grumpyshoe.beertastic.domain.beer.usecase.GetFavorites
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerDataState
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerUIItem
import com.grumpyshoe.beertastic.result.onError
import com.grumpyshoe.beertastic.result.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBeers: GetBeers,
    private val getBeerById: GetBeerById,
    private val getFavorites: GetFavorites,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _viewState = MutableStateFlow<BeerDataState>(BeerDataState.Loading)
    val viewState = _viewState.asStateFlow()

    private val _beerList = MutableStateFlow<List<Beer>>(emptyList())
    val beerList = combine(_beerList, getFavorites()) { beers, favorites ->
        beers.filter { !favorites.contains(it.id) }.map {
            it.toBeerUiItem()
        }
    }

    val favorites = getFavorites().map { newBeerList ->
        newBeerList.map { beerId ->
            val favoriteBeerList = mutableListOf<BeerUIItem>()
            getBeerById(beerId)
                .onSuccess { beer ->
                    favoriteBeerList.add(beer.toBeerUiItem())
                }
            favoriteBeerList
        }.flatten()
    }

    private var page = 1

    init {
        loadBeerData()
    }

    private fun loadBeerData() {
        viewModelScope.launch(ioDispatcher) {
            getBeers(page)
                .onSuccess { beerList ->

                    val currentItems = _beerList.value
                    val newItems = currentItems + beerList
                    _beerList.emit(newItems)

                    if (_viewState.value !is BeerDataState.DataLoaded) {
                        _viewState.emit(BeerDataState.DataLoaded())
                    }
                }
                .onError {
                    _viewState.emit(BeerDataState.Error())
                }
        }
    }

    private fun Beer.toBeerUiItem(): BeerUIItem {
        return BeerUIItem(
            id = id,
            name = name,
            shortDescription = description.shortenTo50Chars(),
            imageUrl = imageUrl,
            tagline = tagline
        )
    }

    fun loadMoreData() {
        page++
        loadBeerData()
    }
}

private fun String?.shortenTo50Chars(): String {
    return if (this != null && this.length > 50) {
        "${this.substring(0, 50)}..."
    } else {
        this
    } ?: ""
}
