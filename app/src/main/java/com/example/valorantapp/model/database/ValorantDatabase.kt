package com.example.valorantapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Agent::class], version = 1, exportSchema = false)
abstract class ValorantDatabase: RoomDatabase() {
    abstract fun agentDao(): AgentDao
}