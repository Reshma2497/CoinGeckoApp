package com.example.coingecko.data.model.exchanges


import com.google.gson.annotations.SerializedName

data class ExchangesItemModel(
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean? = false,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("trade_volume_24h_btc")
    val tradeVolume24hBtc: Double? = 0.0,
    @SerializedName("trade_volume_24h_btc_normalized")
    val tradeVolume24hBtcNormalized: Double? = 0.0,
    @SerializedName("trust_score")
    val trustScore: Int? = 0,
    @SerializedName("trust_score_rank")
    val trustScoreRank: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("year_established")
    val yearEstablished: Int? = 0
)