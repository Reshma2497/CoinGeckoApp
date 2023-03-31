package com.example.coingecko.data.model.categories


import com.google.gson.annotations.SerializedName

data class CategoriesItemModel(
    @SerializedName("category_id")
    val categoryId: String? = "",
    @SerializedName("name")
    val name: String? = ""
)