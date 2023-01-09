package com.example.valorantapp.core.repository

import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.ValorantApiResponse
import com.example.valorantapp.modules.Weapon

interface ValorantRepositoryInterface {
    suspend fun getAgents(): ValorantApiResponse<List<Agent>>
    suspend fun getBuddies(): ValorantApiResponse<List<Buddy>>
    suspend fun getWeapons(): ValorantApiResponse<List<Weapon>>
}