package com.example.valorantapp.ui.agentdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.valorantapp.core.repository.ValorantRepositoryInterface


class AgentDetailsViewModelFactory(
    private val valorantRepositoryInterface: ValorantRepositoryInterface,
    private val uuid: String
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ValorantRepositoryInterface::class.java, String::class.java)
            .newInstance(valorantRepositoryInterface, uuid)
    }
}