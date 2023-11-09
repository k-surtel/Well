package com.ks.well.presentation.main

import com.ks.well.domain.model.Sleep
import java.time.LocalDate

data class DisplayState (
    val selectedDate: LocalDate = LocalDate.now(),
    val sleep: List<Sleep> = emptyList()
)