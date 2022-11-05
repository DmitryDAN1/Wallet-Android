package com.kirodan.shared

import android.content.Context

object Shared {
    fun init(
        applicationContext: Context
    ): SharedModel = try {
        SharedModel.Ready(
            a = "string",
        )
    } catch (e: Throwable) {
        SharedModel.Failure
    }
}
