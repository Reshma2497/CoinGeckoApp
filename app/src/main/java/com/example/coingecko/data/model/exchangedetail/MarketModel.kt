package com.example.coingecko.data.model.exchangedetail


import com.google.gson.annotations.SerializedName

data class MarketModel(
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean? = false,
    @SerializedName("identifier")
    val identifier: String? = "",
    @SerializedName("name")
    val name: String? = ""
)