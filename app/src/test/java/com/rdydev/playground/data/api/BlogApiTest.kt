package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.domain.Comment
import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.model.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BlogApiTest {

    private val blogService = StubBlogService()
    private val sut = BlogApi(blogService)

    @Test
    fun `get users contains correct domain models`() {
        val apiUser = blogService.getUsers().get(0)
        val users = sut.getUsers()

        assertThat(users)
            .hasSize(2)
            .contains(
                User(
                    id = apiUser.id,
                    name = apiUser.name,
                    username = apiUser.username,
                    email = apiUser.email
                )
            )
    }

    @Test
    fun `get posts contains correct domain models`() {
        val apiPost = blogService.getPosts().get(0)
        val posts = sut.getPosts()

        assertThat(posts)
            .hasSize(5)
            .contains(
                Post(
                    id = apiPost.id,
                    userId = apiPost.userId,
                    title = apiPost.title,
                    body = apiPost.body
                )
            )
    }

    @Test
    fun `get comments contains correct domain models`() {
        val apiComment = blogService.getComments().get(0)
        val comments = sut.getComments()

        assertThat(comments)
            .hasSize(3)
            .contains(
                Comment(
                    id = apiComment.id,
                    postId = apiComment.postId,
                    name = apiComment.name,
                    email = apiComment.email,
                    body = apiComment.body
                )
            )
    }
}