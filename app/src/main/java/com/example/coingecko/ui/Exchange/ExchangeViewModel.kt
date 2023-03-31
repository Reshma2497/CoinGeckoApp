package com.example.coingecko.ui.Exchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingecko.data.model.exchanges.ExchangesModel
import com.example.coingecko.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val exchanges= MutableLiveData<ExchangesModel>()


    fun getExchanges()
    {
        viewModelScope.launch {
            val result=repository.getExchanges()
            exchanges.postValue(result)
        }
    }


}