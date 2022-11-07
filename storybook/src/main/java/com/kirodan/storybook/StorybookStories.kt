package com.kirodan.storybook

import androidx.compose.runtime.Composable
import com.kirodan.storybook.dsl.Stories
import com.kirodan.storybook.stories.buttons.KRDButtonStory

@Composable
fun StorybookStories() {
    Stories {
        storiesOf("Buttons")
            .add("KRDButton") { KRDButtonStory() }
    }
}
