package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.api.Comment
import com.rdydev.playground.data.model.api.Post
import com.rdydev.playground.data.model.api.User
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET

interface BlogService {

    @GET("/users")
    fun getUsers(): Single<List<User>>

    @GET("/comments")
    fun getComments(): Single<List<Comment>>

    @GET("/posts")
    fun getPosts(): Single<List<Post>>

    companion object {
        fun createService(retrofit: Retrofit) = retrofit.create(BlogService::class.java)
    }

}