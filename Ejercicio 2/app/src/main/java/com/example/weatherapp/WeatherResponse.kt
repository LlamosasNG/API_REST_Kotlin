package com.example.weatherapp

data class WeatherResponse(
    val name: String, // Nombre de la ciudad
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,  // Temperatura
    val humidity: Int  // Humedad
)

data class Weather(
    val description: String // Descripción del clima
)