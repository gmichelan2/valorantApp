package com.example.valorantapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valorantapp.core.utils.AGENTS_ACTIVITY
import com.example.valorantapp.core.utils.BUDDIES_ACTIVITY
import com.example.valorantapp.core.utils.WEAPONS_ACTIVITY
import com.example.valorantapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.agentsButton.setOnClickListener { goToActivity(AGENTS_ACTIVITY)}
        binding.buddiesButton.setOnClickListener { goToActivity(BUDDIES_ACTIVITY)}
        binding.weaponsButton.setOnClickListener { goToActivity(WEAPONS_ACTIVITY)}

    }

    private fun goToActivity(activityName: String){
        val intent = when(activityName){
            AGENTS_ACTIVITY -> Intent(this, AgentsActivity::class.java)
            BUDDIES_ACTIVITY -> Intent(this, BuddiesActivity::class.java)
            WEAPONS_ACTIVITY -> Intent(this, WeaponsActivity::class.java)
            else -> null
        }

        intent?.let {
            startActivity(intent)
        }
    }
}