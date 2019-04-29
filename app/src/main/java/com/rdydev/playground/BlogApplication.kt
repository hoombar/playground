package com.rdydev.playground

import android.app.Application
import com.facebook.stetho.Stetho
import com.rdydev.playground.di.dataModule
import com.rdydev.playground.di.networkModule
import com.rdydev.playground.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlogApplication)
            modules(networkModule, dataModule, useCaseModule)
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}