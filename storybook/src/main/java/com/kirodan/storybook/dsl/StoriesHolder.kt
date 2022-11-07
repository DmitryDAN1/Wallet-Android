package com.kirodan.storybook.dsl

import androidx.compose.runtime.Composable

private typealias StoryCreator = @Composable () -> Unit

class StoryConfig(
    val groupName: String,
    val storyName: String,
    val story: StoryCreator,
) {
    val route
        get() = "$groupName/$storyName"
}

internal typealias MutableStoriesMap = MutableMap<String, MutableList<StoryConfig>>
internal typealias StoriesMap = Map<String, List<StoryConfig>>

private val globalStories = mutableMapOf<String, MutableList<StoryConfig>>()

class StoriesHolder internal constructor(
    private val groupName: String,
    private val _stories: MutableStoriesMap = globalStories,
) {
    val stories: StoriesMap = _stories

    constructor(groupName: String) : this(groupName, globalStories)

    fun storiesOf(
        groupName: String,
    ): StoriesHolder {
        return StoriesHolder(groupName)
    }

    fun add(
        storyName: String,
        story: StoryCreator,
    ): StoriesHolder {
        if (!_stories.containsKey(groupName)) {
            _stories[groupName] = mutableListOf()
        }
        _stories[groupName]?.add(
            StoryConfig(
                groupName = groupName,
                storyName = storyName,
                story = story,
            )
        )
        return this
    }
}

internal fun StoriesMap.toStoriesList(): List<StoryConfig> {
    return this.entries.fold(mutableListOf()) { acc, it ->
        (acc + it.value).toMutableList()
    }
}
