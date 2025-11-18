package com.grumpyshoe.beertastic.presentation.features.splashscreen.state

sealed interface SplashScreenState {
    object Loading : SplashScreenState

    object Navigate : SplashScreenState
}
