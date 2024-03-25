package com.example.weather_android_app.mainModule.view.adapters

import com.example.weather_android_app.common.entities.Forecast

interface OnClickListener {

    fun onClick(forecast: Forecast)
}