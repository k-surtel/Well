package com.ks.well.core.presentation

import java.time.LocalDate

sealed class MainEvent {
    data class SelectDate(val date: LocalDate): MainEvent()
}
