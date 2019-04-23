package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.mapper.CommentMapper
import com.rdydev.playground.data.model.mapper.PostMapper
import com.rdydev.playground.data.model.mapper.UserMapper
import com.rdydev.playground.data.model.mapper.apiToDomain

class BlogApi(private val blogService: BlogService) {

    fun getUsers() = blogService.getUsers().apiToDomain(UserMapper)

    fun getComments() = blogService.getComments().apiToDomain(CommentMapper)

    fun getPosts() = blogService.getPosts().apiToDomain(PostMapper)

}