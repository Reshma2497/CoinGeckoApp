package com.example.coingecko.data.model.exchangedetail


import com.google.gson.annotations.SerializedName

data class TickerModel(
    @SerializedName("base")
    val base: String? = "",
    @SerializedName("bid_ask_spread_percentage")
    val bidAskSpreadPercentage: Double? = 0.0,
    @SerializedName("coin_id")
    val coinId: String? = "",
    @SerializedName("converted_last")
    val convertedLast: ConvertedLastModel? = ConvertedLastModel(),
    @SerializedName("converted_volume")
    val convertedVolume: ConvertedVolumeModel? = ConvertedVolumeModel(),
    @SerializedName("is_anomaly")
    val isAnomaly: Boolean? = false,
    @SerializedName("is_stale")
    val isStale: Boolean? = false,
    @SerializedName("last")
    val last: Double? = 0.0,
    @SerializedName("last_fetch_at")
    val lastFetchAt: String? = "",
    @SerializedName("last_traded_at")
    val lastTradedAt: String? = "",
    @SerializedName("market")
    val market: MarketModel? = MarketModel(),
    @SerializedName("target")
    val target: String? = "",
    @SerializedName("target_coin_id")
    val targetCoinId: String? = "",
    @SerializedName("timestamp")
    val timestamp: String? = "",
    //@SerializedName("token_info_url")
   // val tokenInfoUrl: AnyModel? = AnyModel(),
    @SerializedName("trade_url")
    val tradeUrl: String? = "",
    @SerializedName("trust_score")
    val trustScore: String? = "",
    @SerializedName("volume")
    val volume: Double? = 0.0
)