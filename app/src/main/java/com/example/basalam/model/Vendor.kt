package com.example.basalam.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Vendor(
    @ColumnInfo(name= "vendor_name")
    @SerializedName("name")
    @Expose
    val name: String
)
