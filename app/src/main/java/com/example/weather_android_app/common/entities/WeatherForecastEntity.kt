package com.example.weather_android_app.common.entities

data class WeatherForecastEntity(
    val timeZone: String,
    val hourly : List<Forecast>
)
