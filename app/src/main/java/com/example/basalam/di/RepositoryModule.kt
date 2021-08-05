package com.example.omdbapi.di

import com.example.basalam.repository.MainRepository
import com.example.basalam.retrofit.ProductRetrofit
import com.example.basalam.room.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        productRetrofit: ProductRetrofit,
        productsDao: ProductsDao
    ): MainRepository {
        return MainRepository(productRetrofit, productsDao)
    }

}