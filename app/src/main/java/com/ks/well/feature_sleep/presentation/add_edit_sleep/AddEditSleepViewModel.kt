package com.ks.well.feature_sleep.presentation.add_edit_sleep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
import kotlinx.coroutines.launch

class AddEditSleepViewModel(
    private val sleepUseCases: SleepUseCases
): ViewModel() {

    fun onEvent(event: AddEditSleepEvent) {
        when(event) {
            is AddEditSleepEvent.SaveSleep -> {
                viewModelScope.launch {
                    sleepUseCases.addSleepUseCase(
                        event.startDate,
                        event.startTime,
                        event.endDate,
                        event.endTime
                    )
                }
            }

        }
    }
}