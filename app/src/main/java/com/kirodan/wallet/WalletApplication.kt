package com.kirodan.wallet

import android.app.Application
import com.kirodan.shared.Shared
import com.kirodan.shared.SharedModel
import kotlinx.coroutines.flow.MutableStateFlow

class WalletApplication : Application() {

    companion object {
        val sharedModel = MutableStateFlow<SharedModel>(SharedModel.Initialization)
    }

    init {
        sharedModel.value = Shared.init(
            applicationContext = applicationContext,
        )
    }
}
