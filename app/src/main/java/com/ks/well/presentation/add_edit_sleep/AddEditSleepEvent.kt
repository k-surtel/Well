package com.ks.well.presentation.add_edit_sleep

import java.time.LocalDateTime

sealed class AddEditSleepEvent {
    data class SaveSleep(
        val startDateTime: LocalDateTime,
        val endDateTime: LocalDateTime
    ): AddEditSleepEvent()
}