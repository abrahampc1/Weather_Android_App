package com.example.weather_android_app.common.entities

data class Forecast(
    val dt : Long,
    val humidity : Int,
    val temp : Double,
    val weather : List<Weather>,
    val pop : Double
) : WeatherBase(dt, humidity, temp, weather)
