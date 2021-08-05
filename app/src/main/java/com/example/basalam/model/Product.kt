package com.example.basalam.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_products")
class Product(
    @PrimaryKey(autoGenerate = false)
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
    @Embedded
    val rating: Rate,
    @SerializedName("photo")
    @Expose
    @Embedded
    val photo: Photo,
    @SerializedName("vendor")
    @Expose
    @Embedded
    val vendor: Vendor
)