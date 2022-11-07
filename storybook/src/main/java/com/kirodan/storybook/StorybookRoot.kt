package com.kirodan.storybook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kirodan.storybook.dsl.StoryConfig
import com.kirodan.uikit.components.button.KRDButton
import com.kirodan.wallet_theme.WalletTheme

@Composable
internal fun StorybookRoot(
    storiesMap: Map<String, List<StoryConfig>>,
    navigate: (StoryConfig) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(WalletTheme.colors.black600),
        contentPadding = PaddingValues(all = WalletTheme.spacings.s16),
        verticalArrangement = Arrangement.spacedBy(WalletTheme.spacings.s16),
    ) {
        items(storiesMap.toList()) { (groupName, stories) ->
            StorybookGroup(
                name = groupName,
                stories = stories,
                navigate = navigate,
            )
        }
    }
}

@Composable
private fun StorybookGroup(
    name: String,
    stories: List<StoryConfig>,
    navigate: (StoryConfig) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(WalletTheme.shapes.m)
            .background(WalletTheme.colors.mainWhite)
            .padding(all = WalletTheme.spacings.s16),
        verticalArrangement = Arrangement.spacedBy(WalletTheme.spacings.s8),
    ) {
        Text(
            text = name,
            style = WalletTheme.typography.HeadlineSemiBold,
        )
        stories.forEach { storyConfig ->
            KRDButton(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                onClick = { navigate.invoke(storyConfig) },
                backgroundColor = WalletTheme.colors.mainPrimary,
                shape = WalletTheme.shapes.m,
                content = {
                    Text(
                        text = storyConfig.storyName,
                        style = WalletTheme.typography.Body,
                        color = WalletTheme.colors.mainWhite,
                    )
                },
            )
        }
    }
}
