package com.wizard.local_storage

import android.content.Context

interface ILocalStorage {
    sealed interface IModel{
        interface IFailure : IModel
        interface IReady : IModel {
            val applicationContext: Context
        }
    }
}