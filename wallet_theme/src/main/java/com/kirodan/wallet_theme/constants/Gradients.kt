package com.kirodan.wallet_theme.constants

import androidx.compose.ui.graphics.Color
import com.kirodan.wallet_theme.common.AngledLinearGradient
import com.kirodan.wallet_theme.tokens.WalletGradient

private val PRIMARY_GRAD_COLOR1 = defaultPalette.mainPrimary
private val PRIMARY_GRAD_COLOR2 = Color(0xFF2BC947)
private val PRIMARY_GRAD_COLOR3 = Color(0xFF34C759)

private val PrimaryLinear1 = AngledLinearGradient(
    colors = listOf(PRIMARY_GRAD_COLOR1, PRIMARY_GRAD_COLOR2),
    angle = 45.0f
)

private val PrimaryLinear2 = AngledLinearGradient(
    colors = listOf(PRIMARY_GRAD_COLOR1, PRIMARY_GRAD_COLOR3),
    angle = 45.0f
)

private val PrimaryLinear3 = AngledLinearGradient(
    colors = listOf(Color(0xFF4817C1), Color(0xFFC505D6)),
    angle = 315.0f
)

private val PrimaryLinear4 = AngledLinearGradient(
    colors = listOf(PRIMARY_GRAD_COLOR3, PRIMARY_GRAD_COLOR1),
    angle = 45.0f
)

internal val defaultGradients = WalletGradient(
    PrimaryLinear1 = PrimaryLinear1,
    PrimaryLinear2 = PrimaryLinear2,
    PrimaryLinear3 = PrimaryLinear3,
    PrimaryLinear4 = PrimaryLinear4
)
