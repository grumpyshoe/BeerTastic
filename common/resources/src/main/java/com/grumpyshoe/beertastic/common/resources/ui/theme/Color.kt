package com.grumpyshoe.beertastic.common.resources.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.grumpyshoe.common.ui.DefaultLightDarkPreview

// light
val PrimaryLight = Color(0xFF70A47C)
val OnPrimaryLight = Color(0xFFFEFFFF)
val PrimaryContainerLight = Color(0xFF70A47C)
val OnPrimaryContainerLight = Color(0xFFFEFFFF)
val BackgroundLight = Color(0xFFF9F8F8)
val OnBackgroundLight = Color(0xFF2B2B2B)
val SurfaceLight = Color(0xFFFFFFFF)
val OnSurfaceLight = Color(0xFF577B75)

// dark
val PrimaryDark = Color(0xFF49614B)
val OnPrimaryDark = Color(0xFFFFFFFF)
val PrimaryContainerDark = Color(0xFF49614B)
val OnPrimaryContainerDark = Color(0xFFFEFFFF)
val BackgroundDark = Color(0xFF333333)
val OnBackgroundDark = Color(0xFFFFFFFF)
val SurfaceDark = Color(0xFF555555)
val OnSurfaceDark = Color(0xFFFFFFFF)

@DefaultLightDarkPreview
@Composable
private fun ColorTemplatePreview() {

    AppNameTheme {

        val colorList = listOf(
            Triple(
                "Primary",
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.onPrimary
            ),
            Triple(
                "PrimaryContainer",
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.colorScheme.onPrimaryContainer
            ),
            Triple(
                "inversePrimary",
                MaterialTheme.colorScheme.inversePrimary, null
            ),
            Triple(
                "Secondary",
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.colorScheme.onSecondary,
            ),
            Triple(
                "SecondaryContainer",
                MaterialTheme.colorScheme.secondaryContainer,
                MaterialTheme.colorScheme.onSecondaryContainer,
            ),
            Triple(
                "Tertiary",
                MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.onTertiary,
            ),
            Triple(
                "TertiaryContainer",
                MaterialTheme.colorScheme.tertiaryContainer,
                MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            Triple(
                "Background",
                MaterialTheme.colorScheme.background,
                MaterialTheme.colorScheme.onBackground,
            ),
            Triple(
                "Surface",
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.onSurface,
            ),
            Triple(
                "SurfaceVariant",
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.colorScheme.onSurfaceVariant,
            ),
            Triple(
                "SurfaceTine",
                MaterialTheme.colorScheme.surfaceTint, null
            ),
            Triple(
                "InverseSurface",
                MaterialTheme.colorScheme.inverseSurface,
                MaterialTheme.colorScheme.inverseOnSurface,
            ),
            Triple(
                "Error",
                MaterialTheme.colorScheme.error,
                MaterialTheme.colorScheme.onError,
            ),
            Triple(
                "ErrorContainer",
                MaterialTheme.colorScheme.errorContainer,
                MaterialTheme.colorScheme.onErrorContainer,
            ),
            Triple(
                "Outline",
                MaterialTheme.colorScheme.outline,
                MaterialTheme.colorScheme.outlineVariant,
            ),
            Triple(
                "Scrim",
                MaterialTheme.colorScheme.scrim, null
            )
        )

        LazyColumn(contentPadding = PaddingValues(4.dp)) {
            items(colorList) { (name, backgroundColor, foregroundColor) ->
                Box(
                    Modifier
                        .border(1.dp, Color.Black)
                        .background(backgroundColor)
                        .width(40.dp)
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name,
                        color = foregroundColor ?: Color.Unspecified,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}