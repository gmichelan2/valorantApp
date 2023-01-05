package com.example.valorantapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.valorantapp.core.service.ValorantServiceClient
import com.example.valorantapp.databinding.ActivityBuddiesBinding
import com.example.valorantapp.ui.adapters.BuddiesAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuddiesActivity: AppCompatActivity() {

    private lateinit var binding: ActivityBuddiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuddiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

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