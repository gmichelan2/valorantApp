package com.example.valorantapp.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.valorantapp.model.Ability
import com.example.valorantapp.model.Role

@Entity
data class Agent(@PrimaryKey(autoGenerate = true)
                 val uuid: String,
                 val displayName: String,
                 val description: String,
                 val developerName: String,
                 val displayIconSmall: String,
                 val fullPortrait: String,
                 val killfeedPortrait: String,
                 val background: String,
                 val role: Role,
                 val abilities: List<Ability>
                 )
