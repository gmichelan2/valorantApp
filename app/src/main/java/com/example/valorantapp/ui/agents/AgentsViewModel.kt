package com.example.valorantapp.ui.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.UIState

class AgentsViewModel(private val valorantRepository: ValorantRepositoryInterface)
    : ViewModel() {
    private val _uiState = MutableLiveData<UIState<Agent>>(UIState<Agent>())
    private val uiState: LiveData<UIState<Agent>> get() {
        if(uiState.value?.dataList == null){
            loadScreen()
        }
        return _uiState
    }
}