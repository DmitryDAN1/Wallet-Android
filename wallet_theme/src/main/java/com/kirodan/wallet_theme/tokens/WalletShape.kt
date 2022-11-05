package com.kirodan.wallet_theme.tokens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
data class WalletShape(
    val zero: RoundedCornerShape = RoundedCornerShape(0.dp),
    val xxs: RoundedCornerShape = RoundedCornerShape(4.dp),
    val xs: RoundedCornerShape = RoundedCornerShape(8.dp),
    val sm: RoundedCornerShape = RoundedCornerShape(12.dp),
    val m: RoundedCornerShape = RoundedCornerShape(16.dp),
    val l: RoundedCornerShape = RoundedCornerShape(20.dp),
    val xl: RoundedCornerShape = RoundedCornerShape(32.dp),
    val rounded: RoundedCornerShape = RoundedCornerShape(percent = 100)
)
