package com.example.valorantapp.core.service

import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.BaseData
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.Weapon
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantService {

    @GET("agents")
     suspend fun getAgents(
        @Query("language") language: String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ) : BaseData<List<Agent>>

     @GET("buddies")
     suspend fun getBuddies(
         @Query("language") language: String
     ) : BaseData<List<Buddy>>

     @GET("weapons")
     suspend fun getWeapons(
         @Query("language") language: String
     ) : BaseData<List<Weapon>>
}
