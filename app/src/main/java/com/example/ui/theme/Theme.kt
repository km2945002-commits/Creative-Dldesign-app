package com.example.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val StudioDarkColorScheme = darkColorScheme(
    primary = AmberGold,
    onPrimary = Obsidian950,
    primaryContainer = AmberGoldDark,
    onPrimaryContainer = Obsidian950,
    secondary = NeonCyan,
    onSecondary = Obsidian950,
    secondaryContainer = Obsidian700,
    onSecondaryContainer = CyanGlow,
    tertiary = ElectricPurple,
    onTertiary = TextPrimary,
    background = Obsidian950,
    onBackground = TextPrimary,
    surface = Obsidian900,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceCard,
    onSurfaceVariant = TextSecondary,
    outline = BorderSubtle,
    outlineVariant = BorderHighlight
)

private val StudioLightColorScheme = lightColorScheme(
    primary = AmberGoldDark,
    onPrimary = TextPrimary,
    primaryContainer = AmberGoldLight,
    onPrimaryContainer = Obsidian950,
    secondary = NeonCyan,
    onSecondary = TextPrimary,
    background = Obsidian950, // Maintain deep studio aesthetic
    onBackground = TextPrimary,
    surface = Obsidian900,
    onSurface = TextPrimary,
    outline = BorderSubtle
)

@Composable
fun CreativeDesignTheme(
    darkTheme: Boolean = true, // Default to stunning dark agency theme
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) StudioDarkColorScheme else StudioLightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            window?.let {
                it.statusBarColor = Obsidian950.toArgb()
                it.navigationBarColor = Obsidian950.toArgb()
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = false
                WindowCompat.getInsetsController(it, view).isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// Alias for backwards compatibility
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) = CreativeDesignTheme(darkTheme = true, content = content)
