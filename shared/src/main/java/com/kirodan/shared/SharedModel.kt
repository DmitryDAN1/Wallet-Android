package com.kirodan.shared

import com.kirodan.env.IEnv
import com.wizard.local_storage.ILocalStorage
import kotlinx.serialization.Serializable

@Serializable
sealed class SharedModel {
    @Serializable
    object Initialization : SharedModel()

    @Serializable
    object Failure : SharedModel()

    @Serializable
    data class Ready(
        val env: IEnv.IModel.IReady,
        val localStorage: ILocalStorage.IModel.IReady
    ) : SharedModel()
}
