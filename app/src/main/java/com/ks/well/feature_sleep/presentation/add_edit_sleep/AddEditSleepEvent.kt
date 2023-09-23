package com.ks.well.feature_sleep.presentation.add_edit_sleep

sealed class AddEditSleepEvent {
    data class SaveSleep(
        val startDate: String,
        val startTime: String,
        val endDate: String,
        val endTime: String
    ): AddEditSleepEvent()
}