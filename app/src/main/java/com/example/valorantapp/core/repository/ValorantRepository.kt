package com.example.valorantapp.core.repository

import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.ValorantApiResponse
import com.example.valorantapp.modules.Weapon

class ValorantRepository: ValorantRepositoryInterface {

    val valorantService = ValorantServiceClient.service

    override suspend fun getAgents(): ValorantApiResponse<Agent> = valorantService.getAgents("es-MX")

    override suspend fun getBuddies(): ValorantApiResponse<Buddy> = valorantService.getBuddies("es-MX")

    override suspend fun getWeapons(): ValorantApiResponse<Weapon> = valorantService.getWeapons("es-MX")
}
