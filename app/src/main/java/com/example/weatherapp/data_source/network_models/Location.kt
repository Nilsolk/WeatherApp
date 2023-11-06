package com.example.weatherapp.data_source.network_models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("Version")
    val version: Int,
    @SerializedName("Key")
    val key: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String,
    @SerializedName("Region")
    val region: Name,
    @SerializedName("Country")
    val country: Name,
    @SerializedName("TimeZone")
    val timeZone: TimeZone,
    @SerializedName("GeoPosition")
    val geoPosition: Position,
    @SerializedName("IsAlias")
    val isAlias: Boolean

)

data class TimeZone(
    @SerializedName("Code")
    val code: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("GmtOffset")
    val gmtOffset: Double,
    @SerializedName("IsDaylightSaving")
    val isDaylightSaving: Boolean,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange: String?

)

data class Name(
    @SerializedName("ID")
    val id: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String,
)

data class Position(
    @SerializedName("Latitude")
    val latitude: Float,
    @SerializedName("Longitude")
    val longitude: Float,
    @SerializedName("Elevation")
    val elevation: Elevation
)

data class Elevation(
    @SerializedName("Metric")
    val metric: Units,
    @SerializedName("Imperial")
    val imperial: Units

)

data class Units(
    @SerializedName("Value")
    val value: Float,
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Float
)
