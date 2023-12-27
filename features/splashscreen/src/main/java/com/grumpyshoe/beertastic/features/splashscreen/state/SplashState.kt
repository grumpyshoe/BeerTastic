package com.grumpyshoe.beertastic.features.splashscreen.state

sealed interface SplashState {
    object Loading : SplashState
    object Navigate : SplashState
}
