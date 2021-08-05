package com.example.basalam.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
    @ColumnInfo(name = "photo_url")
    @SerializedName("url")
    @Expose
    val url: String
)