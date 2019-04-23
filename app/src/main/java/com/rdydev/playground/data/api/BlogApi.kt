package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.mapper.CommentMapper
import com.rdydev.playground.data.model.mapper.PostMapper
import com.rdydev.playground.data.model.mapper.UserMapper
import com.rdydev.playground.data.model.mapper.apiToDomain
import com.rdydev.playground.data.repository.BlogDataProvider

class BlogApi(private val blogService: BlogService) : BlogDataProvider {

    override fun getUsers() = blogService.getUsers().map { it.apiToDomain(UserMapper) }

    override fun getComments() = blogService.getComments().map { it.apiToDomain(CommentMapper) }

    override fun getPosts() = blogService.getPosts().map { it.apiToDomain(PostMapper) }

}