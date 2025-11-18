package com.grumpyshoe.beertastic.presentation.features.splashscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grumpyshoe.beertastic.presentation.features.splashscreen.state.SplashScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow<SplashScreenState>(SplashScreenState.Loading)
    val state: StateFlow<SplashScreenState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            _state.emit(SplashScreenState.Navigate)
        }
    }
}
