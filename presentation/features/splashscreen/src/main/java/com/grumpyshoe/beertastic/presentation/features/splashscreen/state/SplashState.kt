package com.grumpyshoe.beertastic.presentation.features.splashscreen.state

sealed interface SplashState {
    object Loading : SplashState

    object Navigate : SplashState
}
