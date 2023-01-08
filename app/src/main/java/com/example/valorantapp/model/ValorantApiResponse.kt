package com.example.valorantapp.model

data class ValorantApiResponse<T>(val status: Int, val data: T, val error: String)