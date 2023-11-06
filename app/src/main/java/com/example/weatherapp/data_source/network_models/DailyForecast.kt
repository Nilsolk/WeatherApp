package com.example.weatherapp.data_source.network_models

import com.google.gson.annotations.SerializedName


data class DalyForecast(
    @SerializedName("Date")
    val date: String,
    @SerializedName("EpochDate")
    val epochDate: Float,
    @SerializedName("Temperature")
    val temperature: Temperature,
    @SerializedName("Day")
    val day: WeatherParams,
    @SerializedName("Night")
    val night: WeatherParams
)

data class Temperature(
    @SerializedName("Minimum")
    val min: TempValues,
    @SerializedName("Maximum")
    val max: TempValues,
)

data class TempValues(
    @SerializedName("Value")
    val value: Float,
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: String
)

data class WeatherParams(
    @SerializedName("Icon")
    val icon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean
)
