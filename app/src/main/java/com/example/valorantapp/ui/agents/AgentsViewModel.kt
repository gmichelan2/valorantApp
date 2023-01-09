package com.example.valorantapp.ui.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.modules.Agent
import com.example.valorantapp.modules.UIState
import kotlinx.coroutines.launch

class AgentsViewModel(private val valorantRepository: ValorantRepositoryInterface) : ViewModel() {

    private val _uiState = MutableLiveData(UIState<List<Agent>, Agent>())

    val uiState: LiveData<UIState<List<Agent>, Agent>>
        get() {
            if (_uiState.value?.dataList == null) {
                loadScreen()
            }
            return _uiState
        }

    private fun loadScreen() {
        viewModelScope.launch {
            _uiState.value = UIState(loading = true)
            _uiState.value = UIState(dataList = valorantRepository.getAgents())
        }
    }

    fun onAgentClicked(agent: Agent) {
        _uiState.value = uiState.value?.copy(navigateTo = agent)
    }
}
