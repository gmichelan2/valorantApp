package com.example.valorantapp.model

data class UIState<T>(
    val loading: Boolean = false,
    val dataList: ValorantApiResponse<T>? = null
)
