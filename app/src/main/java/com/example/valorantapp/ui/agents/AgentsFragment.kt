package com.example.valorantapp.ui.agents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.databinding.AgentsFragmentBinding
import com.example.valorantapp.ui.adapters.AgentsAdapter
import kotlinx.coroutines.launch

class AgentsFragment: Fragment(R.layout.agents_fragment) {

    private var _binding : AgentsFragmentBinding? = null
    private val binding get()= _binding!!
    private lateinit var agentAdapter : AgentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AgentsFragmentBinding.bind(view).apply {
            agentsList.adapter = agentAdapter
            agentsList.layoutManager = LinearLayoutManager(requireContext())
        }
        lifecycleScope.launch {
            val agents = ValorantServiceClient.service.getAgents("es-wdMX")
            agentAdapter = AgentsAdapter(agents.data)
            agentAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}