package com.example.ktorpoc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorpoc.model.ApiResponse
import com.example.ktorpoc.repository.ApiRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ApiRepository) : ViewModel() {
    private val _response : MutableLiveData<ApiResponse> = MutableLiveData()
    val response : LiveData<ApiResponse> get()  = _response

    fun getResponse(){
        viewModelScope.launch {
            val response = repository.getData()
            _response.value  = response
        }
    }
}