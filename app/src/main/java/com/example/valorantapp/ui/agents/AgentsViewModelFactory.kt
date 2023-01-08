package com.example.valorantapp.ui.agents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.valorantapp.core.repository.ValorantRepositoryInterface

class AgentsViewModelFactory(private val valorantRepository: ValorantRepositoryInterface) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ValorantRepositoryInterface::class.java)
            .newInstance(valorantRepository)
    }
}