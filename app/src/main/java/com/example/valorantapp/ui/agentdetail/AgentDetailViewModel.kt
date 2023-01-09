package com.example.valorantapp.ui.agentdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.UIState

class AgentDetailViewModel(
    private val repository: ValorantRepositoryInterface,
    private val uuid: String
): ViewModel() {


}