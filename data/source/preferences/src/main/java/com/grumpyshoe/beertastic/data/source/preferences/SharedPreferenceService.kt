package com.grumpyshoe.beertastic.data.source.preferences

import kotlinx.coroutines.flow.StateFlow

interface SharedPreferenceService {
    fun checkIfFavorite(beerId: Int): Boolean
    fun setIsBeerFavorite(beerId: Int, isFavorite: Boolean)

    val favorites: StateFlow<List<Int>>

    companion object {
        const val KEY_FAVORITES = "favorites"
    }
}
