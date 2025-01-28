package com.mikeh.littlelemon.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LittleLemonColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    primaryContainer = PrimaryYellow,
    onPrimaryContainer = PrimaryGreen,
    secondary = PrimaryYellow,
    tertiary = HighlightWhite,
    surfaceVariant = Color.White
)

@Composable
fun LittleLemonTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LittleLemonColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}