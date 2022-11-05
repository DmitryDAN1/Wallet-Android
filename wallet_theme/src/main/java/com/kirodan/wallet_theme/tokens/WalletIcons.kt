package com.kirodan.wallet_theme.tokens

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.kirodan.wallet_theme.R

@Immutable
data class WalletIcons(
    @DrawableRes val plus: Int = R.drawable.plus,
)
