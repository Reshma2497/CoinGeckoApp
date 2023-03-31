package com.example.coingecko.ui.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingecko.data.model.categories.CategoriesModel
import com.example.coingecko.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    val categories=MutableLiveData<CategoriesModel>()


    fun getCategory()
    {
        viewModelScope.launch {
            val result=repository.getCategories()
            categories.postValue(result)
        }
    }


}