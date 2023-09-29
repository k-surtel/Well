package com.ks.well.feature_sleep.presentation.add_edit_sleep

import java.time.LocalDateTime

sealed class AddEditSleepEvent {
    data class SaveSleep(
        val startDateTime: LocalDateTime,
        val endDateTime: LocalDateTime
    ): AddEditSleepEvent()
}