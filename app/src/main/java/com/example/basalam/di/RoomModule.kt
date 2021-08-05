package com.rymo.samplehilt.di

import android.content.Context
import androidx.room.Room
import com.example.basalam.room.AppDatabase
import com.example.basalam.room.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {


    @Singleton
    @Provides
    fun provideProductDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductsDao {
        return appDatabase.getProductsDao()
    }


}