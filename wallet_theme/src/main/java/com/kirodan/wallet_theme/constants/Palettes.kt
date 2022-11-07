package com.kirodan.wallet_theme.constants

import androidx.compose.ui.graphics.Color
import com.kirodan.wallet_theme.tokens.WalletColor

private val MAIN_WHITE = Color(0xFFFFFFFF)
private val MAIN_PRIMARY = Color(0xFF39A5FF)
private val SHADOW_COLOR = Color(0xFFC3CEE0)
private val BLACK_600 = Color(0xFFF7F8FA)
private val RIPPLE_COLOR = Color(0xFF96959B)

internal val defaultPalette = WalletColor(
    mainPrimary = MAIN_PRIMARY,
    mainWhite = MAIN_WHITE,
    shadowColor = SHADOW_COLOR,
    black600 = BLACK_600,
    rippleColor = RIPPLE_COLOR,
)
