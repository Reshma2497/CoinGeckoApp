package com.example.coingecko.ui.coins

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingecko.data.model.coins.CoinsModel
import com.example.coingecko.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val coinsModel= MutableLiveData<CoinsModel>()


    fun getCoins() {
        viewModelScope.launch {
            val result = repository.getCoins()
            coinsModel.postValue(result)
        }

    }
}