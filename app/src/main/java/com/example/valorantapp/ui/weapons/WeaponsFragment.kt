package com.example.valorantapp.ui.weapons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.core.repository.ValorantRepository
import com.example.valorantapp.databinding.WeaponsFragmentBinding
import com.example.valorantapp.model.UIState
import com.example.valorantapp.model.Weapon
import com.example.valorantapp.ui.adapters.WeaponsAdapter
import com.example.valorantapp.ui.agents.AgentsViewModelFactory

class WeaponsFragment: Fragment(R.layout.weapons_fragment) {

    private var binding: WeaponsFragmentBinding? = null
    private val weaponAdapter by lazy {
        WeaponsAdapter(emptyList())
    }
    private val weaponViewModel by viewModels<WeaponsViewModel> {
        AgentsViewModelFactory(ValorantRepository())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WeaponsFragmentBinding.bind(view).apply {
            weaponsList.adapter = weaponAdapter
            weaponsList.layoutManager = GridLayoutManager(requireContext(), 3)
        }
        handleObservers()
    }

    private fun handleObservers(){
        weaponViewModel.uiState.observe(viewLifecycleOwner, this::updateUI)
    }

    private fun updateUI(uiState: UIState<List<Weapon>>){
        binding?.weaponsProgressbar?.visibility = if (uiState.loading) View.VISIBLE else View.GONE
        uiState.dataList?.data?.let(weaponAdapter::setList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
