package com.example.coingecko.data.model.exchangedetail


import com.google.gson.annotations.SerializedName

data class ExchangeDetailModel(
    @SerializedName("alert_notice")
    val alertNotice: String? = "",
    @SerializedName("centralized")
    val centralized: Boolean? = false,
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("facebook_url")
    val facebookUrl: String? = "",
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean? = false,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("other_url_1")
    val otherUrl1: String? = "",
    @SerializedName("other_url_2")
    val otherUrl2: String? = "",
    @SerializedName("public_notice")
    val publicNotice: String? = "",
    @SerializedName("reddit_url")
    val redditUrl: String? = "",
    @SerializedName("slack_url")
    val slackUrl: String? = "",
    //@SerializedName("status_updates")
    //val statusUpdates: List<AnyModel?>? = listOf(),
    @SerializedName("telegram_url")
    val telegramUrl: String? = "",
    @SerializedName("tickers")
    val tickers: List<TickerModel?>? = listOf(),
    @SerializedName("trade_volume_24h_btc")
    val tradeVolume24hBtc: Double? = 0.0,
    @SerializedName("trade_volume_24h_btc_normalized")
    val tradeVolume24hBtcNormalized: Double? = 0.0,
    @SerializedName("trust_score")
    val trustScore: Int? = 0,
    @SerializedName("trust_score_rank")
    val trustScoreRank: Int? = 0,
    @SerializedName("twitter_handle")
    val twitterHandle: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("year_established")
    val yearEstablished: Int? = 0
)