package com.rdydev.playground.di

import com.rdydev.playground.posts.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetPostsUseCase(get()) }

}