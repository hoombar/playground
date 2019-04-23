package com.rdydev.playground.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rdydev.playground.data.model.domain.Comment

@Dao
interface CommentDao {

    @Query("SELECT * FROM comment")
    fun getAll(): List<Comment>

    @Query("SELECT * FROM comment WHERE id = :id")
    fun getById(id: Int): Comment

    @Query("SELECT * FROM comment WHERE post_id = :postId")
    fun getForPost(postId: Int): Comment

    @Insert
    fun insertAll(vararg comment: Comment)

}