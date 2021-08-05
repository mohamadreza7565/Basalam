package com.example.basalam.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rate(

    @ColumnInfo(name = "rate_rating")
    @SerializedName("rating")
    @Expose
    val rating: Float,
    @ColumnInfo(name = "rate_count")
    @SerializedName("count")
    @Expose
    val count: Int

)