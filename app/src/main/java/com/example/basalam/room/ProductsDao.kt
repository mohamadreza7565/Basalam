package com.example.basalam.room

import androidx.room.*
import com.example.basalam.model.Product

@Dao
public interface ProductsDao {

    @Query("SELECT * FROM tbl_products")
    suspend fun get(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product): Long


}