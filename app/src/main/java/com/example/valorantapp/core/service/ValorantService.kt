package com.example.valorantapp.core.service

import com.example.valorantapp.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantService {

    @GET("agents")
     suspend fun getAgents(
        @Query("language") language: String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ) : ValorantApiResponse<List<Agent>>

     @GET("buddies")
     suspend fun getBuddies(
         @Query("language") language: String
     ) : ValorantApiResponse<List<Buddy>>

     @GET("weapons")
     suspend fun getWeapons(
         @Query("language") language: String
     ) : ValorantApiResponse<List<Weapon>>

     @GET("agent/{id}")
     suspend fun getAgentById(
         @Query("language") language: String,
         uuid: String) : ValorantApiResponse<Agent>
}
