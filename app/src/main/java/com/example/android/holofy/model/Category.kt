package com.example.android.holofy.model

import com.google.gson.annotations.SerializedName

data class Category(@SerializedName("name") val name:String,@SerializedName("videos") val videoList:List<Video>) {
}