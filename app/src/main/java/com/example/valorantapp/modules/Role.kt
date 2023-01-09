package com.example.valorantapp.modules

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Role(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String
    ):Parcelable