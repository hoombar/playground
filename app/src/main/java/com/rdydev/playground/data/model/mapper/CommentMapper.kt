package com.rdydev.playground.data.model.mapper

import com.rdydev.playground.data.model.domain.Comment

object CommentMapper : Mappable<com.rdydev.playground.data.model.api.Comment, Comment> {

    override fun map(api: com.rdydev.playground.data.model.api.Comment): Comment {
        return Comment(
            id = api.id,
            postId = api.postId,
            name = api.name,
            email = api.email,
            body = api.body
        )
    }

}