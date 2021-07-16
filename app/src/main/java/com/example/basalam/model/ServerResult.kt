package com.example.basalam.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServerResult(

    @SerializedName("data")
    @Expose
    val data: Data

)