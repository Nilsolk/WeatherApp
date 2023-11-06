package com.example.weatherapp.repository

import com.example.weatherapp.data_source.Api
import com.example.weatherapp.data_source.network_models.BaseModel
import com.example.weatherapp.data_source.network_models.DailyForecasts
import com.example.weatherapp.data_source.network_models.HourlyForecast
import com.example.weatherapp.data_source.network_models.Location
import retrofit2.Response

class WeatherRepoImpl(private val api: Api) : WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request {
            api.searchLocation(query = query)
        }
    }

    override suspend fun getDailyForecast(locationKey: String): BaseModel<DailyForecasts> {
        return request {
            api.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecast(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            api.getHourlyForecasts(locationKey = locationKey)
        }
    }


}

suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    try {
        request().also {
            return if (it.isSuccessful) {
                BaseModel.Success(it.body()!!)
            } else BaseModel.Error(it.errorBody()?.string().toString())
        }
    } catch (e: Exception) {
        return BaseModel.Error(e.message.toString())
    }
}

