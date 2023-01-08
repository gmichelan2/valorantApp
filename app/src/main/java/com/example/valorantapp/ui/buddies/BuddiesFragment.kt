package com.example.valorantapp.ui.buddies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.core.repository.ValorantRepository
import com.example.valorantapp.databinding.BuddiesFragmentBinding
import com.example.valorantapp.model.Buddy
import com.example.valorantapp.model.UIState
import com.example.valorantapp.ui.adapters.BuddiesAdapter
import com.example.valorantapp.ui.agents.AgentsViewModelFactory

class BuddiesFragment: Fragment(R.layout.buddies_fragment) {

    private var _binding: BuddiesFragmentBinding? = null
    private val buddiesViewModel by viewModels<BuddiesViewModel>{
        AgentsViewModelFactory(ValorantRepository())
    }
    private val buddiesAdapter by lazy{ BuddiesAdapter(emptyList()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = BuddiesFragmentBinding.bind(view).apply {
            buddiesList.adapter = buddiesAdapter
            buddiesList.layoutManager = GridLayoutManager(requireContext(), 4)
        }
        handleObservers()
    }

    private fun handleObservers(){
        buddiesViewModel.uiState.observe(viewLifecycleOwner, this::updateUI)
    }

    private fun updateUI(uiState: UIState<List<Buddy>>){
        _binding?.buddiesProgressbar?.visibility = if (uiState.loading) View.VISIBLE else View.GONE
        uiState.dataList?.data?.let(buddiesAdapter::setList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}