package com.rdydev.playground

import android.app.Application
import com.facebook.stetho.Stetho
import com.rdydev.playground.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlogApplication)
            modules(networkModule, dataModule, useCaseModule, presenterModule)
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}