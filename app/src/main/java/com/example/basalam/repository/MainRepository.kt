package com.example.basalam.repository

import com.example.basalam.retrofit.ProductRetrofit
import com.example.basalam.room.ProductsDao
import com.example.basalam.utils.DataState
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val productRetrofit: ProductRetrofit,
    private val productsDao: ProductsDao
) {
    suspend fun getProducts(query: String) = flow {
        if (productsDao.get().isEmpty())
            emit(DataState.Loading)
        else {
            emit(DataState.Success(productsDao.get()))
        }

        try {
            val networkProducts = productRetrofit.getProducts(query)
            var products = networkProducts.data.productSearch.products
            for (product in products) {
                productsDao.insert(product)
            }
            emit(DataState.Success(products))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

}