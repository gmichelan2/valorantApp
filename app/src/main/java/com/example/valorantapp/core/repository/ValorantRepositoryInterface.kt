package com.example.valorantapp.core.repository

import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.Weapon

interface ValorantRepositoryInterface {
    suspend fun getAgents(): List<Agent>
    suspend fun getBuddies(): List<Buddy>
    suspend fun getWeapons(): List<Weapon>
}