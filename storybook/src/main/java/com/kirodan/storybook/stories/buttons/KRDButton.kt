package com.kirodan.storybook.stories.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kirodan.uikit.components.button.KRDButton
import com.kirodan.wallet_theme.WalletTheme

@Composable
fun KRDButtonStory() {
    LazyColumn(
        contentPadding = PaddingValues(WalletTheme.spacings.s16),
    ) {
        item {
            KRDButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WalletTheme.spacings.s48),
                onClick = {},
                backgroundColor = WalletTheme.colors.mainPrimary,
                content = { Text(text = "Content") }
            )
        }
    }
}
