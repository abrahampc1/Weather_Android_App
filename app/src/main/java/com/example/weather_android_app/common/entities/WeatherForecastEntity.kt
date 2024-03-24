package com.example.weather_android_app.common.entities

data class WeatherForecastEntity(
    val timezone: String,
    val current: Current,
    val hourly : List<Forecast>
)
