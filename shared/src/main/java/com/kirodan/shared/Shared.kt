package com.kirodan.shared

import android.content.Context
import com.kirodan.env.EnvGradleSecretsImpl
import com.kirodan.env.IEnv
import com.wizard.local_storage.ILocalStorage
import com.wizard.local_storage.LocalStorageImpl

object Shared {
    fun init(applicationContext: Context): SharedModel = try {

        val envModel = EnvGradleSecretsImpl.init() as IEnv.IModel.IReady
        val localStorageModel = LocalStorageImpl.init(
            applicationContext = applicationContext
        ) as ILocalStorage.IModel.IReady

        SharedModel.Ready(
            env = envModel,
            localStorage = localStorageModel
        )
    } catch (e: Throwable) {
        SharedModel.Failure
    }
}
