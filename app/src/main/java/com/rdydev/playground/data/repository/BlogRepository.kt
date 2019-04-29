package com.rdydev.playground.data.repository

import com.rdydev.playground.data.api.BlogApi
import com.rdydev.playground.data.dao.CommentDao
import com.rdydev.playground.data.dao.PostDao
import com.rdydev.playground.data.dao.UserDao
import com.rdydev.playground.data.model.domain.Comment
import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.model.domain.User
import io.reactivex.Maybe
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class BlogRepository : KoinComponent, BlogDataProvider {

    private val postDao: PostDao by inject()
    private val commentDao: CommentDao by inject()
    private val userDao: UserDao by inject()

    private val blogApi: BlogApi by inject()

    override fun getUsers(): Single<List<User>> {
        return userDao.getAll()
            .flatMap {
                if (!it.isEmpty()) {
                    Single.just(it)
                } else {
                    blogApi.getUsers()
                        .map { value ->
                            userDao.insertAll(*value.toTypedArray()).subscribe()
                            value
                        }
                }
            }
    }

    override fun getComments(): Single<List<Comment>> {
        return blogApi.getComments()
    }

    override fun getPosts(): Single<List<Post>> {
        return postDao.getAll()
            .flatMap {
                if (!it.isEmpty()) {
                    Single.just(it)
                } else {
                    blogApi.getPosts()
                        .map { value ->
                            postDao.insertAll(*value.toTypedArray()).subscribe();
                            value
                        }
                }
            }
    }

    fun getPost(postId: Int) : Maybe<Post> {
        return postDao.get(postId)
    }
}
