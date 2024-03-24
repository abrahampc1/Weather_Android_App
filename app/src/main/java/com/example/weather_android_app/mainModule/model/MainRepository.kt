package com.example.weather_android_app.mainModule.model

import com.example.weather_android_app.common.entities.WeatherForecastEntity

class MainRepository {
    private val remoteDataBase = RemoteDataBase()

    suspend fun getWeatherAndForecast(lat : Double, long : Double, appId : String, units : String,
                                      lang : String) : WeatherForecastEntity
    = remoteDataBase.getWeatherForecastByCoordinates(lat, long, appId, units, lang)
}