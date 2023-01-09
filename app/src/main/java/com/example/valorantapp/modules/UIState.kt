package com.example.valorantapp.modules

data class UIState<T,V>(
    val loading: Boolean = false,
    val dataList: ValorantApiResponse<T>? = null,
    val navigateTo: V? = null
)
