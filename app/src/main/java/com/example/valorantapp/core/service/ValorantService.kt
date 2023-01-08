package com.example.valorantapp.core.service

import com.example.valorantapp.modules.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantService {

    @GET("agents")
     suspend fun getAgents(
        @Query("language") language: String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ) : ValorantApiResponse<Agent>

     @GET("buddies")
     suspend fun getBuddies(
         @Query("language") language: String
     ) : ValorantApiResponse<Buddy>

     @GET("weapons")
     suspend fun getWeapons(
         @Query("language") language: String
     ) : ValorantApiResponse<Weapon>
}
