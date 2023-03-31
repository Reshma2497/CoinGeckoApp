package com.example.coingecko.data.model.exchangedetail


import com.google.gson.annotations.SerializedName

data class ConvertedVolumeModel(
    @SerializedName("btc")
    val btc: Double? = 0.0,
    @SerializedName("eth")
    val eth: Double? = 0.0,
    @SerializedName("usd")
    val usd: Double? = 0.0
)