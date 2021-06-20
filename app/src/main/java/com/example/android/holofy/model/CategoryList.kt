package com.example.android.holofy.model

import com.google.gson.annotations.SerializedName

data class CategoryList(
    @SerializedName("categories") val categoryList: List<Category>
) {
}