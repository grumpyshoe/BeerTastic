package com.grumpyshoe.beertastic.features.details.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.grumpyshoe.beertastic.common.navigation.NavigationDestination
import com.grumpyshoe.beertastic.common.navigation.transision.SlideFromRight
import com.grumpyshoe.beertastic.common.navigation.transision.TransitionDuration
import com.grumpyshoe.beertastic.features.details.ui.DetailsRoute

object DetailsDestination : NavigationDestination {

    const val BEER_ID = "beerId"
    override val route: String = "details-route?$BEER_ID={$BEER_ID}"
    override val destination: String = "details-destination"
    fun route(beerId: Int): String {
        return route.replace("{$BEER_ID}", beerId.toString())
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detailsGraph(
    navigateBack: () -> Unit,
) {
    composable(
        route = DetailsDestination.route,
        enterTransition = { SlideFromRight.enter(durationMillis = TransitionDuration.NORMAL) },
        exitTransition = { SlideFromRight.exit(durationMillis = TransitionDuration.NORMAL) },
        popEnterTransition = { SlideFromRight.popEnter(durationMillis = TransitionDuration.NORMAL) },
        popExitTransition = { SlideFromRight.popExit(durationMillis = TransitionDuration.NORMAL) },
    ) {
        DetailsRoute(
            navigateBack = navigateBack,
        )
    }
}
