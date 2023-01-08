package com.example.valorantapp.modules

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
)