package com.grumpyshoe.beertastic.common.resources.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppFont.robotoFont

internal object AppFont {
    val robotoFont =
        FontFamily(
            Font(R.font.roboto_regular, weight = FontWeight.Normal),
            Font(R.font.roboto_medium, weight = FontWeight.Medium),
            Font(R.font.roboto_bold, weight = FontWeight.SemiBold),
            Font(R.font.roboto_bold, weight = FontWeight.Bold),
        )
}

class AppTypography(val material: Typography, val customFont: TextStyle)

val appTypography = AppTypography(
    material = Typography(
        displayLarge =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 57.sp,
            lineHeight = 64.sp,
        ),
        displayMedium =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 45.sp,
            lineHeight = 52.sp,
        ),
        displaySmall =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp,
            lineHeight = 44.sp,
        ),
        headlineLarge =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp,
        ),
        headlineMedium =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 36.sp,
        ),
        headlineSmall =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 32.sp,
        ),
        titleLarge =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
        ),
        titleMedium =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp,
        ),
        titleSmall =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
        ),
        labelLarge =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
        ),
        labelMedium =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
        ),
        labelSmall =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
        ),
        bodyLarge =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp,
        ),
        bodyMedium =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
        ),
        bodySmall =
        TextStyle(
            fontFamily = robotoFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp,
        ),
    ),
    customFont = TextStyle(
        // A custom typography. Just for demonstration (not used in app)
        fontFamily = robotoFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { appTypography }
