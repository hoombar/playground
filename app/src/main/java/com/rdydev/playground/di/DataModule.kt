package com.rdydev.playground.di

import com.rdydev.playground.data.database.AppDatabase
import com.rdydev.playground.data.repository.BlogRepository
import org.koin.dsl.module

val dataModule = module {

    single { BlogRepository() }

    single { AppDatabase(get()).commentDao() }
    single { AppDatabase(get()).postDao() }
    single { AppDatabase(get()).userDao() }

}