package com.rdydev.playground.di

import com.rdydev.playground.Navigation
import org.koin.dsl.module

val navigationModule = module {

    single { Navigation(get()) }

}