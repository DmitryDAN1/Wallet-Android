package com.kirodan.wallet

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.kirodan.shared.SharedModel
import com.kirodan.wallet_theme.WalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.wtf(
            "Shared Test",
            when (val shared = WalletApplication.sharedModel.value) {
                is SharedModel.Failure -> "is failure"
                is SharedModel.Initialization -> "is initialization"
                is SharedModel.Ready -> "is ready - a = ${shared.a}"
            }
        )

        setContent {
            Box(
                Modifier
                    .height(WalletTheme.spacings.s64)
                    .fillMaxWidth()
                    .padding(WalletTheme.spacings.s16)
                    .clip(WalletTheme.shapes.l)
                    .background(WalletTheme.colors.mainPrimary)
            )
        }
    }
}
