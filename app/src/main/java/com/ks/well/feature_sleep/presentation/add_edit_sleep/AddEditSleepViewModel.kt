package com.ks.well.feature_sleep.presentation.add_edit_sleep

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class AddEditSleepViewModel(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _endDateTime = mutableStateOf<LocalDateTime>(LocalDateTime.now())
    var endDateTime: State<LocalDateTime> = _endDateTime
    init {
        savedStateHandle.get<Int>("sleepId")?.let {
            Log.d("DEBUGGGGGGG", "sleepId = $it")
            // todo load enddatetime
        }

        val year = savedStateHandle.get<Int>("year")
        val month = savedStateHandle.get<Int>("month")
        val day = savedStateHandle.get<Int>("day")

        if (year != null && month != null && day != null && year != -1 && month != -1 && day != -1) {
            val date = LocalDate.of(year, month, day)
            val time = LocalTime.now()
            _endDateTime.value = LocalDateTime.of(date, time)
        }
    }

    fun onEvent(event: AddEditSleepEvent) {
        when(event) {
            is AddEditSleepEvent.SaveSleep -> {
                viewModelScope.launch {
                    sleepUseCases.addSleepUseCase(
                        event.startDateTime,
                        event.endDateTime
                    )
                }
            }

        }
    }
}