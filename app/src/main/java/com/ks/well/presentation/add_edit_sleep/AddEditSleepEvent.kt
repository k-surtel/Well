package com.ks.well.presentation.add_edit_sleep


sealed class AddEditSleepEvent {
    object SaveSleep : AddEditSleepEvent()
    object DeleteSleep : AddEditSleepEvent()
}