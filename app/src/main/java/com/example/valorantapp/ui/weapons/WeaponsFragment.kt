package com.example.valorantapp.ui.weapons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.valorantapp.R
import com.example.valorantapp.databinding.WeaponsFragmentBinding

class WeaponsFragment: Fragment(R.layout.weapons_fragment) {

    private lateinit var binding: WeaponsFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WeaponsFragmentBinding.bind(view)
    }
}
