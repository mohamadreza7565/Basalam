package com.example.basalam.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basalam.model.Product

@Database(entities = [Product::class], exportSchema = false, version = 1)
 abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "db_basalam"
    }

    abstract fun getProductsDao(): ProductsDao

}