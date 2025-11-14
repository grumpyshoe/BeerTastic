
package com.grumpyshoe.beertastic.presentation.features.home.ui.uimodel

import androidx.compose.runtime.Immutable

@Immutable
sealed class BeerDataState {
    object Loading : BeerDataState()

    class DataLoaded : BeerDataState()

    class Error : BeerDataState()
}
