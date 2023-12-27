package com.grumpyshoe.beertastic.app.system

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class SystemUIState(
    val route: String,
    val fullscreen: Boolean? = null,
    val statusBarColor: Color? = null,
    val statusBarDarkIcons: Boolean? = null
)
