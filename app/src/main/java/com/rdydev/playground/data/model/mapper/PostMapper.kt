package com.rdydev.playground.data.model.mapper

import com.rdydev.playground.data.model.domain.Post

object PostMapper : Mappable<com.rdydev.playground.data.model.api.Post, Post> {

    override fun map(api: com.rdydev.playground.data.model.api.Post): Post {
        return Post(
            id = api.id,
            userId = api.userId,
            title = api.title,
            body = api.body
        )
    }

}