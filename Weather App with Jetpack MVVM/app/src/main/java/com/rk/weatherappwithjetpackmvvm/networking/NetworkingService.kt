package com.rk.weatherappwithjetpackmvvm.networking

import com.rk.weatherappwithjetpackmvvm.model.WeatherApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkingService {
    @GET("data/2.5/onecall?exclude=minutely,hourly,alerts&lang=en&units=imperial")
    suspend fun fetchWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = ""
    ): WeatherApiResponse

}