package com.example.valorantapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.valorantapp.databinding.ActivityBuddiesBinding

class BuddiesActivity: AppCompatActivity() {

    private lateinit var binding: ActivityBuddiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuddiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}