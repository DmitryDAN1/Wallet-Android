package com.kirodan.wallet_theme.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.kirodan.wallet_theme.common.AdvancedShadow

@Immutable
data class WalletShadow(
    val defaultShadowColor: Color,
    val zero: AdvancedShadow,
    val xxs: AdvancedShadow,
    val xs: AdvancedShadow,
    val sm: AdvancedShadow,
    val m: AdvancedShadow,
    val xl: AdvancedShadow,
    val primary: AdvancedShadow
)
