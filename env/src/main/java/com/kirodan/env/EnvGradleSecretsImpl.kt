package com.kirodan.env

import kotlinx.serialization.Serializable

object EnvGradleSecretsImpl {

    @Serializable
    sealed class Model : IEnv.IModel {
        @Serializable
        data class Ready(
            override val apiBase: String
        ) : IEnv.IModel.IReady

        @Serializable
        object Failure : IEnv.IModel.IFailure
    }

    fun init(): IEnv.IModel {
        return try {
            Model.Ready(
                apiBase = BuildConfig.API_BASE
            )
        } catch (e: Throwable) {
            Model.Failure
        }
    }
}
