package com.example.valorantapp.ui.agentdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.databinding.AgentDetailFragmentBinding
import com.example.valorantapp.model.Agent
import com.example.valorantapp.tools.setHttpImage
import com.example.valorantapp.ui.adapters.AbilityAdapter

class AgentDetailFragment: Fragment(R.layout.agent_detail_fragment) {

    private var binding: AgentDetailFragmentBinding? = null
    private val agentArs: AgentDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AgentDetailFragmentBinding.bind(view)
        setUI(agentArs.agent)
    }

    private fun setUI(agent: Agent){
        binding?.agentDetailImage?.setHttpImage(agent.displayIconSmall)
        binding?.agentDetailDesription?.text = agent.description
        binding?.agentAbilityList?.apply {
            adapter = AbilityAdapter(agent.abilities)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
