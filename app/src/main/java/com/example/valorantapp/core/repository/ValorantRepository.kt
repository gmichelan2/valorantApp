package com.example.valorantapp.core.repository

import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.model.Agent
import com.example.valorantapp.model.Buddy
import com.example.valorantapp.model.ValorantApiResponse
import com.example.valorantapp.model.Weapon

class ValorantRepository: ValorantRepositoryInterface {

    val valorantService = ValorantServiceClient.service

    override suspend fun getAgents(): ValorantApiResponse<List<Agent>> = valorantService.getAgents("es-MX")

    override suspend fun getBuddies(): ValorantApiResponse<List<Buddy>> = valorantService.getBuddies("es-MX")

    override suspend fun getWeapons(): ValorantApiResponse<List<Weapon>> = valorantService.getWeapons("es-MX")
}
