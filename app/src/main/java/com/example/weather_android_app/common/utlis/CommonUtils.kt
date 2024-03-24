package com.example.weather_android_app.common.utlis

import com.example.weather_android_app.common.entities.Weather
import com.example.weather_android_app.common.entities.WeatherForecastEntity
import java.text.SimpleDateFormat
import java.util.Locale

object CommonUtils {
    fun getHour(epoch : Long) : String = getFormatedTime(epoch, "HH:mm")

    private fun getFormatedTime(epoch: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch * 1_000)
    }

    fun getWeatherMain(weather : List<Weather>?) : String{
        return if(weather != null && weather.isNotEmpty()) weather[0].main else "-"
    }

    fun getWeatherDescription(weather : List<Weather>?) : String{
        return if(weather != null && weather.isNotEmpty()) weather[0].description else "-"
    }
}