package com.example.valorantapp.ui.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.modules.UIState
import com.example.valorantapp.modules.Weapon
import kotlinx.coroutines.launch

class WeaponsViewModel(private val valorantRepository: ValorantRepositoryInterface): ViewModel() {
    private val _uiState = MutableLiveData(UIState<Weapon>())

    val uiState: LiveData<UIState<Weapon>>
        get() {
            if (_uiState.value?.dataList == null) {
                loadScreen()
            }
            return _uiState
        }

    private fun loadScreen() {
        viewModelScope.launch {
            _uiState.value = UIState(loading = true)
            _uiState.value = UIState(dataList = valorantRepository.getWeapons())
        }
    }

    fun onAgentClicked(weapon: Weapon) {
        _uiState.value = uiState.value?.copy(navigateTo = weapon)
    }
}