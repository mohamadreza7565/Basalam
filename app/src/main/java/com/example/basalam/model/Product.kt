package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("weight")
    @Expose
    val weight: Int,
    @SerializedName("price")
    @Expose
    val price: Long,
    @SerializedName("rating")
    @Expose
    val rating: Rate,
    @SerializedName("photo")
    @Expose
    val photo: Photo,
    @SerializedName("vendor")
    @Expose
    val vendor: Vendor
)