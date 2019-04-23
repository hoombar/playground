package com.rdydev.playground.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rdydev.playground.data.model.domain.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getAll(): List<Post>

    @Insert
    fun insertAll(vararg post: Post)

}