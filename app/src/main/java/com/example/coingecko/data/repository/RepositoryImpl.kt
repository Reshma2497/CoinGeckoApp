package com.example.coingecko.data.repository

import com.example.coingecko.data.model.exchangedetail.ExchangeDetailModel
import com.example.coingecko.data.model.exchanges.ExchangesModel
import com.example.coingecko.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
) : Repository {
    override suspend fun getCategories()= apiRequest.getCategories()

    override suspend fun getExchanges()= apiRequest.getExchanges()

    override suspend fun getExchangeDetails(exchangeId:String)=apiRequest.getExchangeDetails(exchangeId)
    override suspend fun getExchangeImage(exchangeImage: String)=apiRequest.getExchangeDetails(exchangeImage)


    override suspend fun getCoins()=apiRequest.getCoins()

}