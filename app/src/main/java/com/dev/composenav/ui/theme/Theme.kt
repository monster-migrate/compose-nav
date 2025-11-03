package com.dev.composenav.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = LeafGreen,
    onPrimary = PureWhite,
    primaryContainer = MidnightBlue,
    onPrimaryContainer = SoftSky,
    inversePrimary = EmeraldWave,
    secondary = AquaGlow,
    onSecondary = DarkNight,
    secondaryContainer = LavenderMist,
    onSecondaryContainer = SlateBlue,
    tertiary = SunsetOrange,
    onTertiary = PureWhite,
    tertiaryContainer = CrimsonBlush,
    onTertiaryContainer = PureWhite,
    background = DarkNight,
    onBackground = LightSilver,
    surface = MidnightBlue,
    onSurface = LightSilver,
    surfaceVariant = GraphiteShadow,
    onSurfaceVariant = SilverMist,
    surfaceTint = MintLeaf,
    inverseSurface = AshGrey,
    inverseOnSurface = GraphiteShadow,
    error = RoseBloom,
    onError = PureWhite,
    errorContainer = Sunbeam,
    onErrorContainer = PureWhite,
    outline = SlateBlue,
    outlineVariant = SteelGrey,
    scrim = DeepMidnight,
    surfaceBright = SilverMist,
    surfaceContainer = MidnightBlue,
    surfaceContainerHigh = AshGrey,
    surfaceContainerHighest = PureCinder,
    surfaceContainerLow = SlateBlue,
    surfaceContainerLowest = AshGrey,
    surfaceDim = SilverMist
)

val LightColorScheme = lightColorScheme(
    primary = LeafGreen,
    onPrimary = PureWhite,
    primaryContainer = MistyGreen,
    onPrimaryContainer = DeepMidnight,
    inversePrimary = LightAqua,
    secondary = LightAqua,
    onSecondary = DeepMidnight,
    secondaryContainer = CloudGrey,
    onSecondaryContainer = MistyGreenLight,
    tertiary = Sunbeam,
    onTertiary = PureWhite,
    tertiaryContainer = RoseBloom,
    onTertiaryContainer = PureWhite,
    background = PureWhite,
    onBackground = DeepMidnight,
    surface = FrostedGrey,
    onSurface = DeepMidnight,
    surfaceVariant = SilverCloud,
    onSurfaceVariant = SilverCloud,
    surfaceTint = LeafGreen,
    inverseSurface = Charcoal,
    inverseOnSurface = PureWhite,
    error = RoseBloom,
    onError = PureWhite,
    errorContainer = Sunbeam,
    onErrorContainer = PureWhite,
    outline = Charcoal,
    outlineVariant = SilverCloud,
    scrim = DeepMidnight,
    surfaceBright = PureWhite,
    surfaceContainer = FrostedGrey,
    surfaceContainerHigh = CloudGrey,
    surfaceContainerHighest = MistyGreen,
    surfaceContainerLow = SilverCloud,
    surfaceContainerLowest = PureWhite,
    surfaceDim = FrostedGrey
)

@Composable
fun ComposeNavTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}