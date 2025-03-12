package com.example.weatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.weatherapp.WeatherApiService
import com.example.weatherapp.WeatherResponse
import com.example.weatherapp.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val textViewWeather = findViewById<TextView>(R.id.textViewDescription)

        buttonSearch.setOnClickListener {
            val city = editTextCity.text.toString()
            if (city.isNotEmpty()) {
                fetchWeather(city, textViewWeather)
            } else {
                Toast.makeText(this, "Ingrese una ciudad", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchWeather(city: String, textView: TextView) {
        val apiKey = "f95c4f1eeb9727f49ae69394f1d0cc27"

        RetrofitClient.instance.getWeather(city, apiKey).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weather = response.body()
                    textView.text = "Ciudad: ${weather?.name}\n" +
                            "Temperatura: ${weather?.main?.temp}°C\n" +
                            "Humedad: ${weather?.main?.humidity}%\n" +
                            "Condición: ${weather?.weather?.firstOrNull()?.description}"
                } else {
                    textView.text = "Error: No se pudo obtener el clima"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                textView.text = "Error: ${t.message}"
            }
        })
    }
}