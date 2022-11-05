package com.kirodan.shared

import kotlinx.serialization.Serializable

@Serializable
sealed class SharedModel {
    @Serializable
    object Initialization : SharedModel()

    @Serializable
    object Failure : SharedModel()

    @Serializable
    data class Ready(
        val a: String
    ) : SharedModel()
}
