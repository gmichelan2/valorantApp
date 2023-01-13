package com.example.valorantapp.model.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {

    @Query("SELECT * FROM Agent")
    fun getAllAgents() : Flow<List<Agent>>

    @Query("SELECT * FROM Agent WHERE id = :id")
    fun getAgent(id: Int) : Flow<Agent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgents(agentsList: List<Agent>)

    @Update
    fun updateAgent(agent: Agent)
}