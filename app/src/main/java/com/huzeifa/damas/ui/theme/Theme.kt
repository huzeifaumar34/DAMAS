package com.huzeifa.damas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DamasColorScheme = darkColorScheme(
    primary = Color(0xFFD6B56D),
    onPrimary = Color(0xFF20190D),
    secondary = Color(0xFF63B895),
    onSecondary = Color(0xFF082318),
    background = Color(0xFF101411),
    onBackground = Color(0xFFF4F0E6),
    surface = Color(0xFF1B241E),
    onSurface = Color(0xFFF4F0E6),
    surfaceVariant = Color(0xFF29352D),
    onSurfaceVariant = Color(0xFFD0D8D0)
)

@Composable
fun DamasTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DamasColorScheme,
        content = content
    )
}
