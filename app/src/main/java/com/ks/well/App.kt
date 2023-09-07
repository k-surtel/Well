package com.ks.well

import android.app.Application
import com.ks.well.di.databaseModule
import com.ks.well.di.repositoryModule
import com.ks.well.di.useCaseModule
import com.ks.well.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}