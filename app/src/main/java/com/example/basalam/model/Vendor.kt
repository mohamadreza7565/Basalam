package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Vendor(
    @SerializedName("name")
    @Expose
    val name: String
)
