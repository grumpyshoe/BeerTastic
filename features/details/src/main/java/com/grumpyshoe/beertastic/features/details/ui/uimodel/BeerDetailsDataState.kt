package com.grumpyshoe.beertastic.features.details.ui.uimodel

import androidx.compose.runtime.Immutable

@Immutable
sealed class BeerDetailsDataState {
    object Loading : BeerDetailsDataState()
    data class DataLoaded(
        val isFavorite: Boolean,
        val data: BeerDetailUIItem
    ) : BeerDetailsDataState()

    class Error : BeerDetailsDataState()
}