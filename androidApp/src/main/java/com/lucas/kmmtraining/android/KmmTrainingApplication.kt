package com.lucas.kmmtraining.android

import android.app.Application
import com.lucas.kmmtraining.android.di.viewModelsModule
import com.lucas.kmmtraining.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmmTrainingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin()  {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@KmmTrainingApplication)
            modules(modules)
        }
    }
}