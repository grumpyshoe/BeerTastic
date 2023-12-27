package com.grumpyshoe.common.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

const val PreviewLight = "1. light"
const val PreviewDark = "2. dark"

const val PreviewGroupLightDark = "light / dark"

@Preview(
    name = PreviewLight,
    group = PreviewGroupLightDark,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = PreviewDark,
    group = PreviewGroupLightDark,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class DefaultLightDarkPreview
