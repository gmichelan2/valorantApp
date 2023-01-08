package com.example.valorantapp.ui.buddies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.modules.Buddy
import com.example.valorantapp.modules.UIState
import kotlinx.coroutines.launch

class BuddiesViewModel(private val valorantRepository: ValorantRepositoryInterface) : ViewModel() {

    private val _uiState = MutableLiveData(UIState<Buddy>())

    val uiState: LiveData<UIState<Buddy>>
        get() {
            if (_uiState.value?.dataList == null) {
                loadScreen()
            }
            return _uiState
        }

    private fun loadScreen() {
        viewModelScope.launch {
            _uiState.value = UIState(loading = true)
            _uiState.value = UIState(dataList = valorantRepository.getBuddies())
        }
    }

    fun onAgentClicked(buddy: Buddy) {
        _uiState.value = uiState.value?.copy(navigateTo = buddy)
    }
}