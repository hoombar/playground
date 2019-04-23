package com.rdydev.playground.posts

import com.rdydev.playground.data.model.domain.Post

sealed class PostScreenState {
    object LoadingState : PostScreenState()
    class DataState(val posts: List<Post>) : PostScreenState()
    class ErrorState(val error: Throwable) : PostScreenState()
    object FinishState : PostScreenState()
}