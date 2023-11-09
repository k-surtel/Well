package com.ks.well.presentation.main

import java.time.LocalDate

sealed class MainEvent {
    data class SelectDate(val date: LocalDate): MainEvent()
}
