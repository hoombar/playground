package com.rdydev.playground.data.repository

import com.rdydev.playground.data.model.domain.Comment
import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.model.domain.User
import io.reactivex.Single

interface BlogDataProvider {

    fun getUsers(): Single<List<User>>

    fun getComments(): Single<List<Comment>>

    fun getPosts(): Single<List<Post>>

}