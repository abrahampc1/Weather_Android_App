package com.example.weather_android_app.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_android_app.BR
import com.example.weather_android_app.R
import com.example.weather_android_app.common.entities.Forecast
import com.example.weather_android_app.common.utlis.CommonUtils
import com.example.weather_android_app.databinding.ActivityMainBinding
import com.example.weather_android_app.mainModule.view.adapters.ForecastAdapter
import com.example.weather_android_app.mainModule.view.adapters.OnClickListener
import com.example.weather_android_app.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        val vm : MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.getSnackbarMsg()?.observe(this){resMsg ->
                Snackbar.make(binding.root, resMsg, Snackbar.LENGTH_LONG).show()
            }
            it.getResult().observe(this){result->
                adapter.submitList(result.hourly)
            }
        }
    }

    private fun setupAdapter(){
        adapter = ForecastAdapter(this)
    }

    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            binding.viewModel?.getWeatherAndForecast(
                24.8093,-107.3948,
                "17877c21cd05ec5efe6ebf50472a1d44", "metric", "en")
        }
    }

    override fun onClick(forecast: Forecast) {
        Snackbar.make(binding.root, CommonUtils.getFullDate(forecast.dt), Snackbar.LENGTH_LONG).show()
    }
}