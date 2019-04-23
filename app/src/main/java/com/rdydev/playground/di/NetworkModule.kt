package com.rdydev.playground.di

import com.rdydev.playground.BuildConfig
import com.rdydev.playground.data.api.BlogApi
import com.rdydev.playground.data.api.BlogService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single { BlogService.createService(get()) }

    single { BlogApi(get()) }

}