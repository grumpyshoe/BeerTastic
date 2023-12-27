package com.grumpyshoe.beertastic.features.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeerById
import com.grumpyshoe.beertastic.domain.beer.usecase.IsBeerFavorite
import com.grumpyshoe.beertastic.domain.beer.usecase.SetIsBeerFavorite
import com.grumpyshoe.beertastic.features.details.navigation.DetailsDestination
import com.grumpyshoe.beertastic.features.details.ui.uimodel.BeerDetailUIItem
import com.grumpyshoe.beertastic.features.details.ui.uimodel.BeerDetailsDataState
import com.grumpyshoe.beertastic.result.onError
import com.grumpyshoe.beertastic.result.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBeerById: GetBeerById,
    private val isBeerFavorite: IsBeerFavorite,
    private val setIsBeerFavorite: SetIsBeerFavorite,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val beerId = savedStateHandle.get<String>(DetailsDestination.BEER_ID)?.toInt()

    private val _beerDetailsDataState = MutableStateFlow<BeerDetailsDataState>(BeerDetailsDataState.Loading)
    val beerDetailsDataState = _beerDetailsDataState.asStateFlow()

    init {

        beerId?.let {
            loadBeerDetails(it)
        }
    }

    private fun loadBeerDetails(beerId: Int?) {

        if (beerId == null) {
            _beerDetailsDataState.tryEmit(BeerDetailsDataState.Error())
            return
        }

        viewModelScope.launch(ioDispatcher) {

            val isFavorite = isBeerFavorite(beerId)

            getBeerById(beerId)
                .onSuccess { beer ->
                    val detailsUIItem = BeerDetailUIItem(
                        id = beer.id,
                        name = beer.name,
                        tagline = beer.tagline,
                        description = beer.description,
                        imageUrl = beer.imageUrl,
                        firstBrewed = beer.firstBrewed,
                        abv = beer.abv.toString(),
                        ibu = beer.ibu.toString(),
                        targetFG = beer.targetFG.toString(),
                        targetOG = beer.targetOG.toString(),
                        ebc = beer.ebc.toString(),
                        srm = beer.srm.toString(),
                        attenuationLevel = beer.attenuationLevel.toString(),
                        volume = beer.volume.let {
                            "${it.value} ${it.unit}"
                        },
                        ph = beer.ph.toString(),
                        boilVolume = beer.boilVolume.let {
                            "${it.value} ${it.unit}"
                        },
                        method = beer.method.let {
                            val mash = it.mashTemp.map { item ->
                                "Mash - ${item.temp.value}° ${item.temp.unit}"
                            }

                            val fermentation = it.fermentation.let { item ->
                                "Fermentation - ${item.temp.value}° ${item.temp.unit}"
                            }

                            val twist = it.twist.let { item ->
                                "Twist - $item"
                            }

                            mash.toMutableList().apply {
                                add(fermentation)
                                add(twist)
                            }
                        },
                        ingredients = listOf(
                            beer.ingredients.malt.map {
                                "${it.name} - ${it.amount.value} ${it.amount.unit}"
                            }
                            // handle other parts
                        ).flatten(),
                        foodPairing = beer.foodPairing,
                        brewersTips = beer.brewersTips,
                        contributedBy = beer.contributedBy,
                    )
                    _beerDetailsDataState.tryEmit(
                        BeerDetailsDataState.DataLoaded(
                            isFavorite = isFavorite,
                            data = detailsUIItem
                        )
                    )
                }
                .onError {
                    _beerDetailsDataState.tryEmit(BeerDetailsDataState.Error())
                }
        }
    }

    fun toggleFavorite() {

        if (beerId == null) return

        viewModelScope.launch(ioDispatcher) {
            val currentState = isBeerFavorite(beerId)
            setIsBeerFavorite(beerId, !currentState)

            val state = _beerDetailsDataState.value
            if (state is BeerDetailsDataState.DataLoaded) {
                _beerDetailsDataState.emit(state.copy(isFavorite = !currentState))
            }
        }
    }
}
