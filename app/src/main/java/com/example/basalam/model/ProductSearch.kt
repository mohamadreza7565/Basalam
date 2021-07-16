package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductSearch(
    @SerializedName("products")
    @Expose
    val products: ArrayList<Product>
)