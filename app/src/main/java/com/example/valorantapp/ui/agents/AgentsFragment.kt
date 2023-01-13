package com.example.valorantapp.ui.agents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.core.repository.ValorantRepository
import com.example.valorantapp.databinding.AgentsFragmentBinding
import com.example.valorantapp.model.Agent
import com.example.valorantapp.model.UIState
import com.example.valorantapp.ui.adapters.AgentsAdapter
import kotlinx.coroutines.launch

class AgentsFragment : Fragment(R.layout.agents_fragment) {

    private lateinit var agentMainState :  AgentsMainState
    private val agentAdapter: AgentsAdapter by lazy {
        AgentsAdapter(emptyList()) { agent -> agentMainState.onAgentClick(agent) }
    }

    private val mAgentsViewModel by viewModels<AgentsViewModel> {
        AgentsViewModelFactory(ValorantRepository())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //se debe crear cada vez que se crea la vista si recibe un scope
        agentMainState = AgentsMainState(findNavController())

        val binding = AgentsFragmentBinding.bind(view).apply {
            agentsList.adapter = agentAdapter
            agentsList.layoutManager = LinearLayoutManager(requireContext())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mAgentsViewModel.uiState.collect {
                    binding.loading = it.loading
                    binding.agents = it.dataList?.data
                }
            }
        }
    }

    private fun AgentsFragmentBinding.updateUI(uiState: UIState<List<Agent>>) {
        agentsProgressbar.visibility = if (uiState.loading) View.VISIBLE else View.GONE
        uiState.dataList?.data?.let(agentAdapter::setList)
    }

}