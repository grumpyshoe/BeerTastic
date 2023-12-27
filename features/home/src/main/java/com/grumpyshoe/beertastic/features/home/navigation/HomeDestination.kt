package com.grumpyshoe.beertastic.features.home.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.grumpyshoe.beertastic.common.navigation.NavigationDestination
import com.grumpyshoe.beertastic.common.navigation.transision.SlideFromRight
import com.grumpyshoe.beertastic.common.navigation.transision.TransitionDuration
import com.grumpyshoe.beertastic.features.home.ui.HomeRoute

object HomeDestination : NavigationDestination {
    override val route: String = "home-route"
    override val destination: String = "home-destination"
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeGraph(
    showDetails: (Int) -> Unit,
) {
    composable(
        route = HomeDestination.route,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            SlideFromRight.exit()
        },
        popEnterTransition = { SlideFromRight.popEnter(TransitionDuration.NORMAL) },
    ) {
        HomeRoute(
            showDetails = showDetails,
        )
    }
}
