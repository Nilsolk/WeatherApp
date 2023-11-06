package com.example.weatherapp.repository

import com.example.weatherapp.data_source.network_models.BaseModel
import com.example.weatherapp.data_source.network_models.DailyForecasts
import com.example.weatherapp.data_source.network_models.HourlyForecast
import com.example.weatherapp.data_source.network_models.Location

interface WeatherRepo {
    suspend fun searchLocation(query: String): BaseModel<List<Location>>
    suspend fun getDailyForecast(locationKey: String): BaseModel<DailyForecasts>
    suspend fun getHourlyForecast(locationKey: String): BaseModel<List<HourlyForecast>>
}