package com.example.coingecko.data.model.coins


import com.google.gson.annotations.SerializedName

data class CoinsItemModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("symbol")
    val symbol: String? = ""
)