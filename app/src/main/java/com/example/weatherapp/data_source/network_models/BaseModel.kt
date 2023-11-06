package com.example.weatherapp.data_source.network_models

sealed class BaseModel<out T> {
    class Success<T>(val data: T) : BaseModel<T>()
    class Error(val error: String) : BaseModel<Nothing>()
    object Loading : BaseModel<Nothing>()
}
