package com.kirodan.wallet_theme.constants

import androidx.compose.ui.unit.dp
import com.kirodan.wallet_theme.common.AdvancedShadow
import com.kirodan.wallet_theme.tokens.WalletShadow

private const val defaultShadowAlpha = 0.2f
private const val greenShadowAlpha = 0.4f

private val defaultShadowColorBase = defaultPalette.shadowColor
private val defaultShadowColor = defaultShadowColorBase.copy(alpha = defaultShadowAlpha)
private val greenShadowColor = defaultPalette.mainPrimary.copy(alpha = greenShadowAlpha)

private val zero = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 0.dp,
    shadowBlurRadius = 0.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val xxs = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 1.dp,
    shadowBlurRadius = 2.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val xs = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 2.dp,
    shadowBlurRadius = 4.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val sm = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 4.dp,
    shadowBlurRadius = 8.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val m = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 6.dp,
    shadowBlurRadius = 12.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val xl = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 10.dp,
    shadowBlurRadius = 20.dp,
    spread = 0.dp,
    color = defaultShadowColor
)

private val primary = AdvancedShadow(
    offsetX = 0.dp,
    offsetY = 5.dp,
    shadowBlurRadius = 15.dp,
    spread = 0.dp,
    color = greenShadowColor
)

internal val defaultShadows = WalletShadow(
    defaultShadowColor = defaultShadowColor,
    zero = zero,
    xxs = xxs,
    xs = xs,
    sm = sm,
    m = m,
    xl = xl,
    primary = primary
)
