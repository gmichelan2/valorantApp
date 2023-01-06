package com.example.valorantapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.valorantapp.R
import com.example.valorantapp.databinding.MainFragmentBinding


class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding : MainFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)

        with(binding){
            agentsButton.setOnClickListener { goToFragment(R.id.agentsFragment)}
            buddiesButton.setOnClickListener { goToFragment(R.id.buddiesFragment)}
            weaponsButton.setOnClickListener { goToFragment(R.id.weaponsFragment)}
        }

    }

    private fun goToFragment(direction: Int){
        findNavController().navigate(direction)
    }
}