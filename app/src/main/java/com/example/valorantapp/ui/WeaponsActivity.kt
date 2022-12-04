package com.example.valorantapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.valorantapp.databinding.ActivityWeaponsBinding

class WeaponsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWeaponsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeaponsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}