package com.example.valorantapp.core.repository

import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.Weapon

class ValorantRepository: ValorantRepositoryInterface {

    val valorantService = ValorantServiceClient.service
    override suspend fun getAgents(): List<Agent> = valorantService.getAgents("es-wdMX")

    override suspend fun getBuddies(): List<Buddy> = valorantService.getBuddies("es-wdMX")

    override suspend fun getWeapons(): List<Weapon> = valorantService.getWeapons("es-wdMX")
}
