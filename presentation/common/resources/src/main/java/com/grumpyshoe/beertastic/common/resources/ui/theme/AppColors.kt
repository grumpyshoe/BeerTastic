package com.grumpyshoe.beertastic.common.resources.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val primaryLight = Color(0xFF7BAE7F)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFFDDECD9)
val onPrimaryContainerLight = Color(0xFF304E33)

val secondaryLight = Color(0xFF92B39A)
val onSecondaryLight = Color(0xFF1F3523)
val secondaryContainerLight = Color(0xFFE6F2E4)
val onSecondaryContainerLight = Color(0xFF2D4731)

val tertiaryLight = Color(0xFFB5CDB8)
val onTertiaryLight = Color(0xFF233524)
val tertiaryContainerLight = Color(0xFFE8F5E9)
val onTertiaryContainerLight = Color(0xFF2A3E2A)

val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF410002)

val backgroundLight = Color(0xFFF7FAF5)
val onBackgroundLight = Color(0xFF1D241C)
val surfaceLight = Color(0xFFF7FAF5)
val onSurfaceLight = Color(0xFF1D241C)

val surfaceVariantLight = Color(0xFFDCE5DB)
val onSurfaceVariantLight = Color(0xFF424A41)
val outlineLight = Color(0xFF717B70)
val outlineVariantLight = Color(0xFFBFC8BB)
val scrimLight = Color(0xFF000000)

val inverseSurfaceLight = Color(0xFF2E352C)
val inverseOnSurfaceLight = Color(0xFFEFF3ED)
val inversePrimaryLight = Color(0xFF9CCEA0)

val surfaceDimLight = Color(0xFFDDE2DB)
val surfaceBrightLight = Color(0xFFF7FAF5)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF0F4EE)
val surfaceContainerLight = Color(0xFFEAEFE8)
val surfaceContainerHighLight = Color(0xFFE4EAE3)
val surfaceContainerHighestLight = Color(0xFFDEE4DD)

// ===== DARK THEME =====

val primaryDark = Color(0xFF9CCEA0)
val onPrimaryDark = Color(0xFF15351B)
val primaryContainerDark = Color(0xFF506E53)
val onPrimaryContainerDark = Color(0xFFDDECD9)

val secondaryDark = Color(0xFF9DBEA2)
val onSecondaryDark = Color(0xFF142B17)
val secondaryContainerDark = Color(0xFF3C5841)
val onSecondaryContainerDark = Color(0xFFDDECD9)

val tertiaryDark = Color(0xFFBFD8C2)
val onTertiaryDark = Color(0xFF1C2E1F)
val tertiaryContainerDark = Color(0xFF405D46)
val onTertiaryContainerDark = Color(0xFFE8F5E9)

val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)

val backgroundDark = Color(0xFF121812)
val onBackgroundDark = Color(0xFFDEE5D8)
val surfaceDark = Color(0xFF121812)
val onSurfaceDark = Color(0xFFDEE5D8)

val surfaceVariantDark = Color(0xFF3E4A3C)
val onSurfaceVariantDark = Color(0xFFBFC8BB)
val outlineDark = Color(0xFF899384)
val outlineVariantDark = Color(0xFF3E4A3C)
val scrimDark = Color(0xFF000000)

val inverseSurfaceDark = Color(0xFFE4EAE3)
val inverseOnSurfaceDark = Color(0xFF243022)
val inversePrimaryDark = Color(0xFF7BAE7F)

val surfaceDimDark = Color(0xFF0F150E)
val surfaceBrightDark = Color(0xFF343B33)
val surfaceContainerLowestDark = Color(0xFF0A1009)
val surfaceContainerLowDark = Color(0xFF171D16)
val surfaceContainerDark = Color(0xFF1B211A)
val surfaceContainerHighDark = Color(0xFF252C24)
val surfaceContainerHighestDark = Color(0xFF30372E)

class AppColors(
    val material: ColorScheme,
    val customColor1: Color, // A custom color. Just for demonstration (not used in app)
)

val lightColors by lazy {
    AppColors(
        material = lightColorScheme(
            primary = primaryLight,
            onPrimary = onPrimaryLight,
            primaryContainer = primaryContainerLight,
            onPrimaryContainer = onPrimaryContainerLight,
            secondary = secondaryLight,
            onSecondary = onSecondaryLight,
            secondaryContainer = secondaryContainerLight,
            onSecondaryContainer = onSecondaryContainerLight,
            tertiary = tertiaryLight,
            onTertiary = onTertiaryLight,
            tertiaryContainer = tertiaryContainerLight,
            onTertiaryContainer = onTertiaryContainerLight,
            error = errorLight,
            onError = onErrorLight,
            errorContainer = errorContainerLight,
            onErrorContainer = onErrorContainerLight,
            background = backgroundLight,
            onBackground = onBackgroundLight,
            surface = surfaceLight,
            onSurface = onSurfaceLight,
            surfaceVariant = surfaceVariantLight,
            onSurfaceVariant = onSurfaceVariantLight,
            outline = outlineLight,
            outlineVariant = outlineVariantLight,
            scrim = scrimLight,
            inverseSurface = inverseSurfaceLight,
            inverseOnSurface = inverseOnSurfaceLight,
            inversePrimary = inversePrimaryLight,
            surfaceDim = surfaceDimLight,
            surfaceBright = surfaceBrightLight,
            surfaceContainerLowest = surfaceContainerLowestLight,
            surfaceContainerLow = surfaceContainerLowLight,
            surfaceContainer = surfaceContainerLight,
            surfaceContainerHigh = surfaceContainerHighLight,
            surfaceContainerHighest = surfaceContainerHighestLight,
        ),
        customColor1 = Color.Magenta,
    )
}

val darkColors by lazy {
    AppColors(
        material = darkColorScheme(
            primary = primaryDark,
            onPrimary = onPrimaryDark,
            primaryContainer = primaryContainerDark,
            onPrimaryContainer = onPrimaryContainerDark,
            secondary = secondaryDark,
            onSecondary = onSecondaryDark,
            secondaryContainer = secondaryContainerDark,
            onSecondaryContainer = onSecondaryContainerDark,
            tertiary = tertiaryDark,
            onTertiary = onTertiaryDark,
            tertiaryContainer = tertiaryContainerDark,
            onTertiaryContainer = onTertiaryContainerDark,
            error = errorDark,
            onError = onErrorDark,
            errorContainer = errorContainerDark,
            onErrorContainer = onErrorContainerDark,
            background = backgroundDark,
            onBackground = onBackgroundDark,
            surface = surfaceDark,
            onSurface = onSurfaceDark,
            surfaceVariant = surfaceVariantDark,
            onSurfaceVariant = onSurfaceVariantDark,
            outline = outlineDark,
            outlineVariant = outlineVariantDark,
            scrim = scrimDark,
            inverseSurface = inverseSurfaceDark,
            inverseOnSurface = inverseOnSurfaceDark,
            inversePrimary = inversePrimaryDark,
            surfaceDim = surfaceDimDark,
            surfaceBright = surfaceBrightDark,
            surfaceContainerLowest = surfaceContainerLowestDark,
            surfaceContainerLow = surfaceContainerLowDark,
            surfaceContainer = surfaceContainerDark,
            surfaceContainerHigh = surfaceContainerHighDark,
            surfaceContainerHighest = surfaceContainerHighestDark,
        ),
        customColor1 = Color.Red,
    )
}

internal val LocalColors =
    staticCompositionLocalOf<AppColors> { error("No CustomColors provided") }

@Preview(heightDp = 1400)
@Composable
private fun ThemeColorsPreview() {
    @Composable
    fun ColorEntry(title: String, light: Color, onLight: Color?, dark: Color?, onDark: Color?) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
            )

            Box(
                modifier = Modifier
                    .size(46.dp, 32.dp)
                    .background(light)
                    .border(width = 1.dp, color = Color.Black),
                contentAlignment = Alignment.Center,
            ) {
                onLight?.let {
                    Box(
                        modifier = Modifier
                            .background(it)
                            .size(16.dp)
                            .border(1.dp, Color.Black),
                    )
                }
            }

            if (dark != null) {
                Box(
                    modifier = Modifier
                        .size(46.dp, 32.dp)
                        .background(dark)
                        .border(width = 1.dp, color = Color.Black),
                    contentAlignment = Alignment.Center,
                ) {
                    onDark?.let {
                        Box(
                            modifier = Modifier
                                .background(it)
                                .size(16.dp)
                                .border(1.dp, Color.Black),
                        )
                    }
                }
            }
        }
    }

    AppTheme {
        Column(
            Modifier
                .background(Color.White)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(4.dp))
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "MaterialTheme Colors",
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Name",
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    modifier = Modifier
                        .width(46.dp),
                    text = "light",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    modifier = Modifier
                        .width(46.dp),
                    text = "dark",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
            }
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "primary",
                light = lightColors.material.primary,
                onLight = lightColors.material.onPrimary,
                dark = darkColors.material.primary,
                onDark = darkColors.material.onPrimary,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "primaryContainer",
                light = lightColors.material.primaryContainer,
                onLight = lightColors.material.onPrimaryContainer,
                dark = darkColors.material.primaryContainer,
                onDark = darkColors.material.onPrimaryContainer,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "inversePrimary",
                light = lightColors.material.inversePrimary,
                onLight = null,
                dark = darkColors.material.inversePrimary,
                onDark = null,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "secondary",
                light = lightColors.material.secondary,
                onLight = lightColors.material.onSecondary,
                dark = darkColors.material.secondary,
                onDark = darkColors.material.onSecondary,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "secondaryContainer",
                light = lightColors.material.secondaryContainer,
                onLight = lightColors.material.onSecondaryContainer,
                dark = darkColors.material.secondaryContainer,
                onDark = darkColors.material.onSecondaryContainer,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "tertiary",
                light = lightColors.material.tertiary,
                dark = darkColors.material.tertiary,
                onLight = lightColors.material.onTertiary,
                onDark = darkColors.material.onTertiary,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "tertiaryContainer",
                light = lightColors.material.tertiaryContainer,
                dark = darkColors.material.tertiaryContainer,
                onLight = lightColors.material.onTertiaryContainer,
                onDark = darkColors.material.onTertiaryContainer,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "background",
                light = lightColors.material.background,
                onLight = lightColors.material.onBackground,
                dark = darkColors.material.background,
                onDark = darkColors.material.onBackground,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surface",
                light = lightColors.material.surface,
                dark = darkColors.material.surface,
                onLight = lightColors.material.onSurface,
                onDark = darkColors.material.onSurface,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceVariant",
                light = lightColors.material.surfaceVariant,
                dark = darkColors.material.surfaceVariant,
                onLight = lightColors.material.onSurfaceVariant,
                onDark = darkColors.material.onSurfaceVariant,
            )
            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceTint",
                light = lightColors.material.surfaceTint,
                dark = lightColors.material.surfaceTint,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceBright",
                light = lightColors.material.surfaceBright,
                dark = lightColors.material.surfaceBright,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceDim",
                light = lightColors.material.surfaceDim,
                dark = lightColors.material.surfaceDim,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceDim",
                light = lightColors.material.surfaceDim,
                dark = lightColors.material.surfaceDim,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "inverseSurface",
                light = lightColors.material.inverseSurface,
                dark = darkColors.material.inverseOnSurface,
                onLight = lightColors.material.inverseSurface,
                onDark = darkColors.material.inverseOnSurface,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceContainer",
                light = lightColors.material.surfaceContainer,
                dark = darkColors.material.surfaceContainer,
                onLight = lightColors.material.onSecondaryContainer,
                onDark = darkColors.material.onSecondaryContainer,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceContainerHigh",
                light = lightColors.material.surfaceContainerHigh,
                dark = lightColors.material.surfaceContainerHigh,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceContainerHighest",
                light = lightColors.material.surfaceContainerHighest,
                dark = lightColors.material.surfaceContainerHighest,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceContainerLow",
                light = lightColors.material.surfaceContainerLow,
                dark = lightColors.material.surfaceContainerLow,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "surfaceContainerLowest",
                light = lightColors.material.surfaceContainerLowest,
                dark = lightColors.material.surfaceContainerLowest,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "error",
                light = lightColors.material.error,
                dark = darkColors.material.error,
                onLight = lightColors.material.onError,
                onDark = darkColors.material.onError,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "errorContainer",
                light = lightColors.material.errorContainer,
                dark = darkColors.material.errorContainer,
                onLight = lightColors.material.onErrorContainer,
                onDark = darkColors.material.onErrorContainer,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "outline",
                light = lightColors.material.outline,
                dark = lightColors.material.outline,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "outlineVariant",
                light = lightColors.material.outlineVariant,
                dark = lightColors.material.outlineVariant,
                onLight = null,
                onDark = null,
            )

            HorizontalDivider(color = Color.Black)
            ColorEntry(
                title = "scrim",
                light = lightColors.material.scrim,
                dark = lightColors.material.scrim,
                onLight = null,
                onDark = null,
            )

//            Row(
//                modifier = Modifier
//                    .padding(vertical = 2.dp)
//                    .background(color = Color.LightGray, shape = RoundedCornerShape(4.dp))
//                    .padding(4.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//            ) {
//                Text(
//                    modifier = Modifier.weight(1f),
//                    text = "Custom Colors",
//                    fontWeight = FontWeight.Bold,
//                )
//            }
//            ColorEntry(
//                title = "accentColor",
//                light = lightColors.accentColor,
//                dark = darkColors.accentColor,
//                onLight = null,
//                onDark = null,
//            )
//            HorizontalDivider(color = Color.Black)
//            ColorEntry(
//                title = "uncheckedTrackColor",
//                light = lightColors.uncheckedTrackColor,
//                dark = darkColors.uncheckedTrackColor,
//                onLight = null,
//                onDark = null,
//            )
//            HorizontalDivider(color = Color.Black)
//            ColorEntry(
//                title = "checkedTrackColor",
//                light = lightColors.checkedTrackColor,
//                dark = darkColors.checkedTrackColor,
//                onLight = null,
//                onDark = null,
//            )
        }
    }
}
