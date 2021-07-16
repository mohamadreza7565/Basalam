package com.example.basalam.app

import com.example.basalam.api.ServerAPI
import com.example.basalam.data.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Build an object of class ServerApi
 */
class RetrofitRequestOptions {
    fun getApi(): ServerAPI {

        val gson = GsonBuilder().setLenient().create()
        val client = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(ServerAPI::class.java)
    }
}