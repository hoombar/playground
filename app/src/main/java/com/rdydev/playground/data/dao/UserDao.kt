package com.rdydev.playground.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rdydev.playground.data.model.domain.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: Int): User

    @Insert
    fun insertAll(vararg user: User)

}