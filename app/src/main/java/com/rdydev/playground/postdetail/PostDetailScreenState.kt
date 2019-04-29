package com.rdydev.playground.postdetail

import com.rdydev.playground.data.model.domain.Post

sealed class PostDetailScreenState {
    object LoadingState : PostDetailScreenState()
    class DataState(val post: Post) : PostDetailScreenState()
    class ErrorState(val error: Throwable) : PostDetailScreenState()
    object FinishState : PostDetailScreenState()
}
