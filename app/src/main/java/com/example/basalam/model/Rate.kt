package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rate(

    @SerializedName("rating")
    @Expose
    val rating: Float,
    @SerializedName("count")
    @Expose
    val count: Int

)