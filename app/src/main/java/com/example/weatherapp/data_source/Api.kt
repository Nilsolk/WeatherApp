package com.example.weatherapp.data_source

import com.example.weatherapp.data_source.network_models.DailyForecasts
import com.example.weatherapp.data_source.network_models.HourlyForecast
import com.example.weatherapp.data_source.network_models.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("apikey") apiKey: String = APIKEY,
        @Query("q") query: String
    ): Response<List<Location>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = IS_METRIC
    ): Response<DailyForecasts>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = IS_METRIC
    ): Response<List<HourlyForecast>>

    companion object {
        private const val APIKEY = "zvO9fr3L6ucmM6JMq9oDJjUgTlyJmTB4"
        private const val IS_METRIC = true
    }
}