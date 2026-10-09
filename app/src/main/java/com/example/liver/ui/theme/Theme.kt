package com.example.liver.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LiverColorScheme = lightColorScheme(
    primary = LiverOrange,
    secondary = LiverGreen,
    tertiary = LiverLightGreen,

    background = LiverCream,
    surface = LiverCream,

    onPrimary = Color.White,
    onSecondary = Color.White,

    onBackground = LiverDark,
    onSurface = LiverDark
)

@Composable
fun LiverTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LiverColorScheme,
        typography = Typography,
        content = content
    )
}