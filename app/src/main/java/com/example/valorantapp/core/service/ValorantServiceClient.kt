package com.example.valorantapp.core.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ValorantServiceClient {

    private val retrofitObject = Retrofit.Builder().baseUrl("https://valorant-api.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofitObject.create(ValorantService::class.java)
}