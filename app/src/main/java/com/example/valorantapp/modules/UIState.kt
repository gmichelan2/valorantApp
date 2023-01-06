package com.example.valorantapp.modules

data class UIState<T>(
    val loading: Boolean = false,
    val dataList: List<T>? = null,
    val navigateTo: T? = null
)
