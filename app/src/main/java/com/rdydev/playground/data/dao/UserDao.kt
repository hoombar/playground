package com.rdydev.playground.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rdydev.playground.data.model.domain.User
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): Single<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: Int): Single<User>

    @Insert
    fun insertAll(vararg user: User): Completable

}