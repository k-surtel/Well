package com.ks.well.core.presentation

import com.ks.well.feature_sleep.domain.model.Sleep
import java.time.LocalDate

data class DisplayState (
    val selectedDate: LocalDate = LocalDate.now(),
    val sleep: List<Sleep> = emptyList()
)