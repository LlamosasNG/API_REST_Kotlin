package com.example.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface WeatherApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,          // Ciudad
        @Query("appid") apiKey: String,    // API Key
        @Query("units") units: String = "metric", // Unidades métricas (°C)
        @Query("lang") lang: String = "es" // Idioma español
    ): Call<WeatherResponse>
}