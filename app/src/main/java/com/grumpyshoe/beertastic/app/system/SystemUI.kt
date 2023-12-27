package com.grumpyshoe.beertastic.app.system

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemUI(
    navController: NavHostController,
    routeStates: Array<SystemUIState>,
    isDarkIcons: Boolean = false,
    content: @Composable () -> Unit
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentState by remember(currentRoute) {
        mutableStateOf(
            routeStates.firstOrNull { state -> currentRoute?.startsWith(state.route) ?: false }
        )
    }
    val backgroundColor = MaterialTheme.colorScheme.background
    val lightTheme = isSystemInDarkTheme()
    val fullscreen = currentState?.fullscreen ?: false

    val systemUiController = rememberSystemUiController()
    LaunchedEffect(backStackEntry, isDarkIcons) {
        systemUiController.setStatusBarColor(
            color = currentState?.statusBarColor ?: if (fullscreen) {
                Color.Transparent
            } else {
                backgroundColor
            },
            darkIcons = currentState?.statusBarDarkIcons ?: if (fullscreen) {
                isDarkIcons
            } else {
                !lightTheme
            }
        )
    }
    Box(
        modifier = if (fullscreen) {
            Modifier.navigationBarsPadding()
        } else {
            Modifier
        }
    ) { content() }
}
