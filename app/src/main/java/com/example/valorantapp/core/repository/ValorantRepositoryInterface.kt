package com.example.valorantapp.core.repository

import com.example.valorantapp.model.Agent
import com.example.valorantapp.model.Buddy
import com.example.valorantapp.model.ValorantApiResponse
import com.example.valorantapp.model.Weapon

interface ValorantRepositoryInterface {
    suspend fun getAgents(): ValorantApiResponse<List<Agent>>
    suspend fun getBuddies(): ValorantApiResponse<List<Buddy>>
    suspend fun getWeapons(): ValorantApiResponse<List<Weapon>>
}