package com.ks.well.core.presentation

import androidx.lifecycle.ViewModel
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class MainViewModel(
    private val sleepUseCases: SleepUseCases
): ViewModel() {

    private var _selectedDate = MutableStateFlow<LocalDate>(LocalDate.now())
    var selectedDate: StateFlow<LocalDate> = _selectedDate

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.SelectDate -> _selectedDate.value = event.date
        }
    }
}