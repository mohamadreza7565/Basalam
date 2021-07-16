package com.example.basalam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basalam.dao.UserDao
import com.example.basalam.model.User

@Database(entities = arrayOf(User::class), exportSchema = false, version = 1)
 abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getAppDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "db_app")
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun getUserDao(): UserDao

}