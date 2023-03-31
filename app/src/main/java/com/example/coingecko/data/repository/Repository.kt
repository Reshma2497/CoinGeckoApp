package com.example.coingecko.data.repository

import com.example.coingecko.data.model.categories.CategoriesModel
import com.example.coingecko.data.model.coins.CoinsModel
import com.example.coingecko.data.model.exchangedetail.ExchangeDetailModel
import com.example.coingecko.data.model.exchanges.ExchangesModel

interface Repository {

    suspend fun getCategories(): CategoriesModel

    suspend fun getExchanges(): ExchangesModel

    suspend fun getExchangeDetails(exchangeId:String): ExchangeDetailModel

    suspend fun getExchangeImage(exchangeImage:String): ExchangeDetailModel

    suspend fun getCoins(): CoinsModel


}