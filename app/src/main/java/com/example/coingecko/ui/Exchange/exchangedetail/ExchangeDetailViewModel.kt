package com.example.coingecko.ui.Exchange.exchangedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingecko.data.model.exchangedetail.ExchangeDetailModel
import com.example.coingecko.data.model.exchanges.ExchangesModel
import com.example.coingecko.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ExchangeDetailViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val exchangeDetails= MutableLiveData<ExchangeDetailModel>()


    fun getExchangeDetails(exchangeId:String)
    {
        viewModelScope.launch {
            val result=repository.getExchangeDetails(exchangeId)
            exchangeDetails.postValue(result)
        }
    }
    fun getExchangeImage(url: String, fn: (ExchangeDetailModel) -> Unit) {
        viewModelScope.launch {
            val exchangeDetailModel = repository.getExchangeImage(url)
            exchangeDetailModel?.let { it -> fn(it) }
        }

    }
    fun loadMoreExchange(url: String) {
        viewModelScope.launch {
            exchangeDetails.postValue(repository.getExchangeDetails(url))
        }
    }

}