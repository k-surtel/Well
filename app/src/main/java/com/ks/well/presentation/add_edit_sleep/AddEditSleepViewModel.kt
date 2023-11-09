package com.ks.well.presentation.add_edit_sleep

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.well.domain.model.Sleep
import com.ks.well.domain.use_case.sleep.SleepUseCases
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.math.roundToInt

class AddEditSleepViewModel(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var sleep: Sleep? = null

    private var _deletable = mutableStateOf(false)
    var deletable: State<Boolean> = _deletable

    private var _startDateTime = mutableStateOf<LocalDateTime>(LocalDateTime.now().minusHours(8))
    var startDateTime: State<LocalDateTime> = _startDateTime

    private var _endDateTime = mutableStateOf<LocalDateTime>(LocalDateTime.now())
    var endDateTime: State<LocalDateTime> = _endDateTime

    var sliderPosition = mutableFloatStateOf(0f)

    init {
        savedStateHandle.get<Int>("sleepId")?.let {id ->
            viewModelScope.launch {
                val passedSleep = sleepUseCases.getSleepByIdUseCase(id)
                passedSleep?.let {
                    _deletable.value = true
                    sleep = it
                    _startDateTime.value = it.startDateTime
                    _endDateTime.value = it.endDateTime
                    sliderPosition.floatValue = it.quality.toFloat()
                }
            }
        }

        val year = savedStateHandle.get<Int>("year")
        val month = savedStateHandle.get<Int>("month")
        val day = savedStateHandle.get<Int>("day")

        if (year != null && month != null && day != null && year != -1 && month != -1 && day != -1) {
            val date = LocalDate.of(year, month, day)
            val time = LocalTime.now()
            _endDateTime.value = LocalDateTime.of(date, time)
            _startDateTime.value = LocalDateTime.of(date, time).minusHours(8)
        }
    }

    fun changeStartTime(hour: Int, minute: Int) {
        _startDateTime.value = startDateTime.value.withHour(hour).withMinute(minute)
    }

    fun changeStartDate(year: Int, month: Int, day: Int) {
        _startDateTime.value = startDateTime.value.withYear(year).withMonth(month).withDayOfMonth(day)
    }

    fun changeEndTime(hour: Int, minute: Int) {
        _endDateTime.value = endDateTime.value.withHour(hour).withMinute(minute)
    }

    fun changeEndDate(year: Int, month: Int, day: Int) {
        _endDateTime.value = endDateTime.value.withYear(year).withMonth(month).withDayOfMonth(day)
    }

    fun onEvent(event: AddEditSleepEvent) {
        when(event) {
            is AddEditSleepEvent.SaveSleep -> {
                viewModelScope.launch {
                    sleepUseCases.addSleepUseCase(
                        sleep?.id,
                        startDateTime.value,
                        endDateTime.value,
                        sliderPosition.floatValue.roundToInt()
                    )
                }
            }
            is AddEditSleepEvent.DeleteSleep -> {
                viewModelScope.launch {
                    sleep?.let { sleepUseCases.deleteSleepUseCase(it) }
                }
            }

        }
    }
}