package com.example.basalam.dao

import androidx.room.*
import com.example.basalam.model.User

@Dao
public interface UserDao {

    @Query("SELECT * FROM tbl_user")
    fun get(): User

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)

}