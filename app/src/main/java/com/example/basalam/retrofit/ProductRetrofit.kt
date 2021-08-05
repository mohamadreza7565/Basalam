package com.example.basalam.retrofit

import com.example.basalam.model.ServerResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ProductRetrofit {

    companion object{
        var QUERY =  "{productSearch(size: 20) {products {id name photo(size: LARGE) { url } vendor { name } weight price rating { rating count: signals } } } }"
        var BASE_URL = "https://api.basalam.com/api/"
    }

    /**
     * Get products from server with rxJava and retrofit
     */
    @FormUrlEncoded
    @POST("user")
    suspend fun getProducts(@Field("query") query: String) : ServerResult

}