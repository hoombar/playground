package com.rdydev.playground.di

import com.rdydev.playground.postdetail.PostDetailPresenter
import com.rdydev.playground.posts.PostsPresenter
import org.koin.dsl.module

val presenterModule = module {

    factory { PostsPresenter(get()) }

    factory { PostDetailPresenter(get()) }

}