package com.example.weather_android_app.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_android_app.R
import com.example.weather_android_app.common.entities.WeatherForecastEntity
import com.example.weather_android_app.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private val result = MutableLiveData<WeatherForecastEntity>()
    fun getResult() : LiveData<WeatherForecastEntity> = result

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg
    private val loading = MutableLiveData<Boolean>()
    fun isLoad() = loading

    suspend fun getWeatherAndForecast(lat : Double, long : Double, appId : String, units : String,
                                      lang : String){
        viewModelScope.launch {
            try {
                loading.value = false
                val resultServer = repository.getWeatherAndForecast(lat, long, appId, units, lang)
                result.value = resultServer
            }catch (e : Exception){
                snackbarMsg.value = R.string.main_error_server
            }finally {
                loading.value = true
            }
        }
    }

}