package com.grumpyshoe.beertastic.features.splashscreen.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.grumpyshoe.beertastic.common.navigation.NavigationDestination
import com.grumpyshoe.beertastic.common.navigation.transision.FadeIn
import com.grumpyshoe.beertastic.common.navigation.transision.TransitionDuration
import com.grumpyshoe.beertastic.features.splashscreen.ui.SplashRoute

object SplashDestination : NavigationDestination {
    override val route: String = "splash-route"
    override val destination: String = "splash-destination"
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashGraph(navigateForward: () -> Unit) {

    println("nav --- splashGraph")

    composable(
        route = SplashDestination.route,
        exitTransition = { FadeIn.exit(TransitionDuration.NORMAL) }
    ) {

        println("nav --- route: ${SplashDestination.route}")

        SplashRoute(navigateForward = navigateForward)
    }
}
