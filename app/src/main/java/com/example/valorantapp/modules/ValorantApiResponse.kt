package com.example.valorantapp.modules

data class ValorantApiResponse<T>(val status: Int, val data: T, val error: String)