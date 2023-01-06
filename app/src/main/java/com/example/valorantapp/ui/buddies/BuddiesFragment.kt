package com.example.valorantapp.ui.buddies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.valorantapp.R
import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.databinding.BuddiesFragmentBinding
import com.example.valorantapp.ui.adapters.BuddiesAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuddiesFragment: Fragment(R.layout.buddies_fragment) {

    private lateinit var binding: BuddiesFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BuddiesFragmentBinding.bind(view)
        lifecycleScope.launch{
            val data = withContext(Dispatchers.IO){
                ValorantServiceClient.service.getBuddies("es-MX")
            }
            withContext(Dispatchers.Main){
                binding.buddiesList.apply {
                    adapter = BuddiesAdapter(data.data)
                }
            }

        }

    }
}