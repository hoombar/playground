package com.rdydev.playground.posts

import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.repository.BlogRepository
import io.reactivex.Single
import org.koin.core.KoinComponent

class GetPostsUseCase(private val repository: BlogRepository) : KoinComponent {

    fun execute(): Single<List<Post>> {
        // users must be available for the blog posts
        return repository.getUsers()
            .ignoreElement()
            .andThen(repository.getPosts())
    }

}