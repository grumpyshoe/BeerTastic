package com.grumpyshoe.beertastic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppTheme
import com.grumpyshoe.beertastic.navigation.NavigationRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                NavigationRoot(
                    modifier =
                    Modifier
                        .fillMaxSize(),
                )
            }
        }
    }
}
