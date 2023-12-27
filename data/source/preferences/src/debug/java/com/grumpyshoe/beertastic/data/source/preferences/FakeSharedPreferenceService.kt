package com.grumpyshoe.beertastic.data.source.preferences

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeSharedPreferenceService : SharedPreferenceService {

    var checkIfFavoriteResult: Boolean = false
    var requestedBeerId: Int? = null
    var requestedFavoriteState: Boolean? = null

    var favoritesResult: List<Int> = emptyList()

    override fun checkIfFavorite(beerId: Int): Boolean {
        requestedBeerId = beerId
        return checkIfFavoriteResult
    }

    override fun setIsBeerFavorite(beerId: Int, isFavorite: Boolean) {
        requestedBeerId = beerId
        requestedFavoriteState = isFavorite
    }

    override val favorites: StateFlow<List<Int>>
        get() = MutableStateFlow<List<Int>>(favoritesResult)
}
