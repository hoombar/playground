package com.rdydev.playground.postdetail

import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.repository.BlogRepository
import io.reactivex.Maybe
import org.koin.core.KoinComponent

class GetPostUseCase(private val repository: BlogRepository) : KoinComponent {

    fun execute(postId: Int): Maybe<Post> {
        return repository.getPost(postId)
    }

}