package com.grumpyshoe.beertastic.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        resetWindowBackground()
        setContent {
            navController = rememberAnimatedNavController()
            AppNameTheme {
                MainContent(
                    navController = navController,
                )
            }
        }
    }

    /**
     * Android versions below 31 have custom android:windowBackground color in order to avoid
     * the default white background upon opening the application. As windowBackground color is
     * still applied during the application session, we need to reset a color in order to avoid
     * any side-effects custom windowBackground color can cause to the application UI.
     */
    private fun resetWindowBackground() {
        window.setBackgroundDrawableResource(R.color.background)
    }
}
