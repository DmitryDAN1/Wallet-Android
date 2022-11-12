package com.wizard.local_storage

import android.content.Context
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

object LocalStorageImpl {
    @Serializable
    sealed class Model : ILocalStorage.IModel {
        @Serializable
        data class Ready(
            @Contextual
            override val applicationContext: Context
        ) : ILocalStorage.IModel.IReady

        @Serializable
        object Failure : ILocalStorage.IModel.IFailure
    }

    fun init(applicationContext: Context): ILocalStorage.IModel {
        return try {
            Model.Ready(
                applicationContext = applicationContext
            )
        } catch (e: Throwable) {
            Model.Failure
        }
    }
}