package com.example.valorantapp.core.repository

import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.ValorantApiResponse
import com.example.valorantapp.modules.Weapon

interface ValorantRepositoryInterface {
    suspend fun getAgents(): ValorantApiResponse<Agent>
    suspend fun getBuddies(): ValorantApiResponse<Buddy>
    suspend fun getWeapons(): ValorantApiResponse<Weapon>
}