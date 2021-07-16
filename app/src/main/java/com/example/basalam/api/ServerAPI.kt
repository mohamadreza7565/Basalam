package com.example.basalam.api

import com.example.basalam.model.ServerResult
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ServerAPI {

    /**
     * Get products from server with rxJava and retrofit
     */
    @FormUrlEncoded
    @POST("user")
    suspend fun getProducts(@Field("query") query: String) : ServerResult

}