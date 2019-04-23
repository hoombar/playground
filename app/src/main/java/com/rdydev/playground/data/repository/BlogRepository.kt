package com.rdydev.playground.data.repository

import com.rdydev.playground.data.api.BlogApi
import com.rdydev.playground.data.dao.CommentDao
import com.rdydev.playground.data.dao.PostDao
import com.rdydev.playground.data.dao.UserDao
import com.rdydev.playground.data.model.domain.Comment
import com.rdydev.playground.data.model.domain.Post
import com.rdydev.playground.data.model.domain.User
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

interface BlogDataProvider {

    fun getUsers(): Single<List<User>>

    fun getComments(): Single<List<Comment>>

    fun getPosts(): Single<List<Post>>

}

class BlogRepository : KoinComponent, BlogDataProvider {

    val postDao: PostDao by inject()
    val commentDao: CommentDao by inject()
    val userDao: UserDao by inject()

    val blogApi: BlogApi by inject()

    override fun getUsers(): Single<List<User>> {
        return blogApi.getUsers()
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
//                            postDao.insertAll(value).subscribe();
                            value
                        }
                }
            }
    }
}
