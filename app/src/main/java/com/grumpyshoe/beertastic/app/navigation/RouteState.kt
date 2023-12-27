package com.grumpyshoe.beertastic.app.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.grumpyshoe.beertastic.app.system.SystemUIState
import com.grumpyshoe.beertastic.features.details.navigation.DetailsDestination
import com.grumpyshoe.beertastic.features.home.navigation.HomeDestination
import com.grumpyshoe.beertastic.features.splashscreen.navigation.SplashDestination

@Composable
fun rememberSystemUIStates(): Array<SystemUIState> {
    val primaryColor = MaterialTheme.colorScheme.primary
    return remember {
        arrayOf(
            SystemUIState(
                route = SplashDestination.route,
                fullscreen = true,
            ),
            SystemUIState(
                route = HomeDestination.route,
                statusBarColor = primaryColor,
                statusBarDarkIcons = false,
            ),
            SystemUIState(
                route = DetailsDestination.route,
                statusBarColor = primaryColor,
                statusBarDarkIcons = false,
            )
        )
    }
}
