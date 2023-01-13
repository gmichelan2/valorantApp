package com.example.valorantapp.ui.agents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.model.Agent
import com.example.valorantapp.model.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AgentsViewModel(private val valorantRepository: ValorantRepositoryInterface) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState<List<Agent>>())

    val uiState: StateFlow<UIState<List<Agent>>> = _uiState.asStateFlow()

    init {
        loadScreen()
    }

    private fun loadScreen() {
        viewModelScope.launch {
            _uiState.value = UIState(loading = true)
            _uiState.value = UIState(dataList = valorantRepository.getAgents())
        }
    }
}
