
package com.grumpyshoe.beertastic.data.source.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedPreferenceServiceImpl(
    private val encryptedSharedPrefs: SharedPreferences,
) : SharedPreferenceService {
    private val _favorites = MutableStateFlow(getFavorites())
    override val favorites: StateFlow<List<Int>> = _favorites

    override fun checkIfFavorite(beerId: Int): Boolean = encryptedSharedPrefs
        .getString(
            SharedPreferenceService.KEY_FAVORITES,
            null,
        ).let { favorites ->
            favorites?.split(",")?.contains(beerId.toString()) ?: false
        }

    override fun setIsBeerFavorite(
        beerId: Int,
        isFavorite: Boolean,
    ) {
        val favoriteList = getFavorites().toMutableList()

        val updatedList =
            favoriteList.apply {
                if (isFavorite) {
                    add(beerId)
                } else {
                    remove(beerId)
                }
            }

        encryptedSharedPrefs.edit(true) {
            putString(
                SharedPreferenceService.KEY_FAVORITES,
                updatedList.joinToString(separator = ","),
            )
        }
        _favorites.tryEmit(updatedList)
    }

    private fun getFavorites(): List<Int> = encryptedSharedPrefs
        .getString(SharedPreferenceService.KEY_FAVORITES, null)
        ?.split(",")
        ?.mapNotNull {
            try {
                it.toInt()
            } catch (e: Exception) {
                null
            }
        } ?: emptyList()
}
