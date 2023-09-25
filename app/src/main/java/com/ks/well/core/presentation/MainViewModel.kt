package com.ks.well.core.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.well.core.domain.use_case.MainUseCases
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainUseCases: MainUseCases
): ViewModel() {

    private val _displayState = mutableStateOf(DisplayState())
    val displayState: State<DisplayState> = _displayState

    init {
        getSleep()
    }

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.SelectDate -> {
                _displayState.value = _displayState.value.copy(selectedDate = event.date)
                getSleep()
            }
        }
    }

    private fun getSleep() {
        viewModelScope.launch {
            mainUseCases.getSleepRecordsFromDayUseCase(displayState.value.selectedDate).collectLatest {
                _displayState.value = _displayState.value.copy(sleep = it)
            }
        }

    }
}