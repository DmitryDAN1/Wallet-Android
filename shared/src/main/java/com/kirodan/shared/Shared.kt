package com.kirodan.shared

import android.content.Context
import com.kirodan.env.EnvGradleSecretsImpl
import com.kirodan.env.IEnv

object Shared {
    fun init(
        applicationContext: Context
    ): SharedModel = try {
        val envModel = EnvGradleSecretsImpl.init() as IEnv.IModel.IReady
        SharedModel.Ready(
            env = envModel,
        )
    } catch (e: Throwable) {
        SharedModel.Failure
    }
}
