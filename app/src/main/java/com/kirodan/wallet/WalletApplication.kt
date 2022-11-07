package com.kirodan.wallet

import android.app.Application
import com.google.firebase.FirebaseApp
import com.kirodan.shared.Shared
import com.kirodan.shared.SharedModel
import kotlinx.coroutines.flow.MutableStateFlow

class WalletApplication : Application() {

    companion object {
        val sharedModel = MutableStateFlow<SharedModel>(SharedModel.Initialization)
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        sharedModel.value = Shared.init(
            applicationContext = applicationContext,
        )
    }
}
