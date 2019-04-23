package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.mapper.CommentMapper
import com.rdydev.playground.data.model.mapper.PostMapper
import com.rdydev.playground.data.model.mapper.UserMapper
import com.rdydev.playground.data.model.mapper.apiToDomain

class BlogApi(private val blogService: BlogService) {

    fun getUsers() = blogService.getUsers().map { it.apiToDomain(UserMapper) }

    fun getComments() = blogService.getComments().map { it.apiToDomain(CommentMapper) }

    fun getPosts() = blogService.getPosts().map { it.apiToDomain(PostMapper) }

}