package com.example.valorantapp.ui.agents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.core.repository.ValorantRepository
import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.databinding.AgentsFragmentBinding
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.UIState
import com.example.valorantapp.ui.adapters.AgentsAdapter
import kotlinx.coroutines.launch

class AgentsFragment : Fragment(R.layout.agents_fragment) {

    private var _binding: AgentsFragmentBinding? = null
    private val binding get() = _binding!!
    private val agentAdapter: AgentsAdapter by lazy { AgentsAdapter(emptyList()) }

    private val mAgentsViewModel by viewModels<AgentsViewModel> {
        AgentsViewModelFactory(ValorantRepository())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AgentsFragmentBinding.bind(view).apply {
            agentsList.adapter = agentAdapter
            agentsList.layoutManager = LinearLayoutManager(requireContext())
        }
        handleObservers()
    }

    private fun handleObservers() {
        mAgentsViewModel.uiState.observe(viewLifecycleOwner, this::updateUI)
    }

    private fun updateUI(uiState: UIState<Agent>) {
        binding.agentsProgressbar.visibility = if (uiState.loading) View.VISIBLE else View.GONE
        uiState.dataList?.data?.let(agentAdapter::setList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}