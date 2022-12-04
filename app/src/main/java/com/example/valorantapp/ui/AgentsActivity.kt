package com.example.valorantapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.databinding.ActivityAgentsBinding
import com.example.valorantapp.ui.adapters.AgentsAdapter
import kotlinx.coroutines.launch

class AgentsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAgentsBinding
    private lateinit var agentAdapter : AgentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            val agents = ValorantServiceClient.service.getAgents("es-wdMX")
            agentAdapter = AgentsAdapter(agents.data)
            binding.agentsList.apply {
                adapter = agentAdapter
                layoutManager = LinearLayoutManager(this@AgentsActivity)
            }

        }
    }
}