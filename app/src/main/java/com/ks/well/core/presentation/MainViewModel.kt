package com.ks.well.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.well.core.domain.use_case.MainUseCases
import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainViewModel(
    private val mainUseCases: MainUseCases
): ViewModel() {

    private var _selectedDate = MutableStateFlow<LocalDate>(LocalDate.now())
    var selectedDate: StateFlow<LocalDate> = _selectedDate

    var sleep = emptyList<Sleep>()

    init {
        getSleep()
    }

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.SelectDate -> {
                _selectedDate.value = event.date
                getSleep()
            }
        }
    }

    private fun getSleep() {
        viewModelScope.launch {
            mainUseCases.getSleepRecordsFromDayUseCase(selectedDate.value).collectLatest {
                sleep = it
            }
        }

    }
}