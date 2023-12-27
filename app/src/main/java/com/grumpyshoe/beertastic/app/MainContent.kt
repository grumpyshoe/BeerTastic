package com.grumpyshoe.beertastic.app

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.grumpyshoe.beertastic.app.navigation.rememberSystemUIStates
import com.grumpyshoe.beertastic.app.system.SystemUI
import com.grumpyshoe.beertastic.features.details.navigation.DetailsDestination
import com.grumpyshoe.beertastic.features.details.navigation.detailsGraph
import com.grumpyshoe.beertastic.features.home.navigation.HomeDestination
import com.grumpyshoe.beertastic.features.home.navigation.homeGraph
import com.grumpyshoe.beertastic.features.splashscreen.navigation.SplashDestination
import com.grumpyshoe.beertastic.features.splashscreen.navigation.splashGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent(
    navController: NavHostController,
) {
    val isDarkIcons by remember { mutableStateOf(false) }

    SystemUI(
        navController = navController,
        routeStates = rememberSystemUIStates(),
        isDarkIcons = isDarkIcons,
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = SplashDestination.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None },
        ) {
            splashGraph(
                navigateForward = {
                    navController.navigate(HomeDestination.route) {
                        this.popUpTo(navController.graph.id)
                    }
                },
            )

            homeGraph(
                showDetails = {
                    navController.navigate(DetailsDestination.route(it))
                },
            )

            detailsGraph(
                navigateBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}
