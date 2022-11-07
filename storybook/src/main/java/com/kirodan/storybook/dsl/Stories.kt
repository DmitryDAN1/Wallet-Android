package com.kirodan.storybook.dsl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kirodan.storybook.StorybookRoot
import com.kirodan.wallet_theme.WalletThemeProvider

private const val START_DESTINATION_KEY = "@storybook/route"

@Composable
fun Stories(
    getStories: StoriesHolder.() -> Unit,
) {
    val navController = rememberNavController()
    val storiesMap = remember { StoriesHolder("default").apply(getStories).stories }

    WalletThemeProvider {
        NavHost(
            navController = navController,
            startDestination = START_DESTINATION_KEY,
        ) {
            composable(START_DESTINATION_KEY) {
                StorybookRoot(
                    storiesMap = storiesMap,
                    navigate = { storyConfig -> navController.navigate(storyConfig.route) },
                )
            }

            storiesMap.toStoriesList().forEach { config ->
                composable(config.route) { config.story() }
            }
        }
    }
}
