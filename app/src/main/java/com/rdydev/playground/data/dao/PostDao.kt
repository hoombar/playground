package com.rdydev.playground.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rdydev.playground.data.model.domain.Post
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getAll(): Single<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<Post>): Completable

}