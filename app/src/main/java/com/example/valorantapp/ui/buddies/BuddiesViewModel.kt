package com.example.valorantapp.ui.buddies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.core.repository.ValorantRepositoryInterface
import com.example.valorantapp.model.Buddy
import com.example.valorantapp.model.UIState
import kotlinx.coroutines.launch

class BuddiesViewModel(private val valorantRepository: ValorantRepositoryInterface) : ViewModel() {

    private val _uiState = MutableLiveData(UIState<List<Buddy>>())

    val uiState: LiveData<UIState<List<Buddy>>>
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
}
