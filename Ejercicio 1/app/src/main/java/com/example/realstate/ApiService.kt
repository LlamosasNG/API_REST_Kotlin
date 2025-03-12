package com.example.realstate

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("auth/login")
    fun getStatus(): Call<ApiResponse>
}

data class ApiResponse(
    val msg: String
)