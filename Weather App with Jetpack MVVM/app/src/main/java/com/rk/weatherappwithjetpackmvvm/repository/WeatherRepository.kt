package com.rk.weatherappwithjetpackmvvm.repository

import com.rk.weatherappwithjetpackmvvm.networking.NetworkingService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val networkingService: NetworkingService) {
    suspend fun fetchWeather(lat: String, lon: String) =
        networkingService.fetchWeather(lat, lon)
}