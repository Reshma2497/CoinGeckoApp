package com.example.coingecko.data.remote

import com.example.coingecko.data.model.categories.CategoriesModel
import com.example.coingecko.data.model.coins.CoinsModel
import com.example.coingecko.data.model.exchangedetail.ExchangeDetailModel
import com.example.coingecko.data.model.exchanges.ExchangesModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {

    @GET(ApiDetails.CATEGORIES)
    suspend fun getCategories(): CategoriesModel

    @GET(ApiDetails.Exchanges)
    suspend fun getExchanges(): ExchangesModel

    @GET(ApiDetails.ExchangeDetail)
    suspend fun getExchangeDetails(@Path("id") id: String):ExchangeDetailModel

    @GET(ApiDetails.COINS)
    suspend fun getCoins():CoinsModel
}