package com.example.valorantapp.ui.agents

import androidx.navigation.NavController
import com.example.valorantapp.model.Agent

class AgentsMainState( private val navController: NavController) {

     fun onAgentClick(agent: Agent) {
        val action = AgentsFragmentDirections.actionAgentsFragmentToAgentDetailFragment(agent)
        navController.navigate(action)
    }
}