package com.example.valorantapp.modules

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val displayIconSmall: String,
    val fullPortrait: String,
    val killfeedPortrait: String,
    val background: String,
    val role: Role,
    val abilities: List<Ability>,
): Parcelable