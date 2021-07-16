package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("url")
    @Expose
    val url: String
)