package com.rdydev.playground.postdetail

import com.rdydev.playground.data.model.domain.Post

sealed class PostDetailScreenState {
    object Loading : PostDetailScreenState()
    class DataAvailable(val post: Post) : PostDetailScreenState()
    class Error(val error: Throwable) : PostDetailScreenState()
    object FinishedLoading : PostDetailScreenState()
}
