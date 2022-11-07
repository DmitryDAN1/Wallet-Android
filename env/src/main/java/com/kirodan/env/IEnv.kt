package com.kirodan.env

interface IEnv {
    sealed interface IModel {
        interface IFailure : IModel
        interface IReady : IModel {
            val apiBase: String
        }
    }
}
