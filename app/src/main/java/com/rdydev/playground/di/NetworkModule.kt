package com.rdydev.playground.di

import com.rdydev.playground.BuildConfig
import com.rdydev.playground.data.api.BlogApi
import com.rdydev.playground.data.api.BlogService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_ROOT)
            .build()
    }

    single { BlogService.createService(get()) }

    single { BlogApi(get()) }

}