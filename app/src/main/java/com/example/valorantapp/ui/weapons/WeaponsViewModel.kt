package com.example.valorantapp.ui.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.model.UIState
import com.example.valorantapp.model.Weapon
import kotlinx.coroutines.launch

class WeaponsViewModel(private val valorantRepository: ValorantRepositoryInterface): ViewModel() {
    private val _uiState = MutableLiveData(UIState<List<Weapon>>())

    val uiState: LiveData<UIState<List<Weapon>>>
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
}
