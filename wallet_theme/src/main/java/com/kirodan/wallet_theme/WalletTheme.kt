package com.kirodan.wallet_theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.kirodan.wallet_theme.constants.*
import com.kirodan.wallet_theme.constants.defaultPalette
import com.kirodan.wallet_theme.constants.defaultShadows
import com.kirodan.wallet_theme.constants.defaultSpacings
import com.kirodan.wallet_theme.constants.defaultTypography
import com.kirodan.wallet_theme.tokens.*

private val LocalWalletColors = staticCompositionLocalOf { defaultPalette }

private val LocalWalletTypography = staticCompositionLocalOf { defaultTypography }

private val LocalWalletShape = staticCompositionLocalOf { WalletShape() }

private val LocalWalletShadow = staticCompositionLocalOf { defaultShadows }

private val LocalWalletSpacing = staticCompositionLocalOf { defaultSpacings }

private val LocalWalletGradient = staticCompositionLocalOf { defaultGradients }

private val LocalWalletIcons = staticCompositionLocalOf { WalletIcons() }

object WalletTheme {
    val colors: WalletColor
        @Composable
        get() = LocalWalletColors.current

    val typography: WalletTypography
        @Composable
        get() = LocalWalletTypography.current

    val shapes: WalletShape
        @Composable
        get() = LocalWalletShape.current

    val shadows: WalletShadow
        @Composable
        get() = LocalWalletShadow.current

    val spacings: WalletSpacing
        @Composable
        get() = LocalWalletSpacing.current

    val gradients: WalletGradient
        @Composable
        get() = LocalWalletGradient.current

    val icons: WalletIcons
        @Composable
        get() = LocalWalletIcons.current
}

@Composable
fun WalletThemeProvider(
    colors: WalletColor = defaultPalette,
    spacings: WalletSpacing = defaultSpacings,
    shadows: WalletShadow = defaultShadows,
    shape: WalletShape = WalletShape(),
    typography: WalletTypography = defaultTypography,
    gradients: WalletGradient = defaultGradients,
    icons: WalletIcons = WalletIcons(),
    allowFontScaling: Boolean = false,
    content: @Composable () -> Unit
) {
    val processedTypography = if (allowFontScaling) typography else typography.withoutFontScale()
    CompositionLocalProvider(
        LocalWalletColors provides colors,
        LocalWalletTypography provides processedTypography,
        LocalWalletShape provides shape,
        LocalWalletShadow provides shadows,
        LocalWalletSpacing provides spacings,
        LocalWalletGradient provides gradients,
        LocalWalletIcons provides icons,
        content = content
    )
}
