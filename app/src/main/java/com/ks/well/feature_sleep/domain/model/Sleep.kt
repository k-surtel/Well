package com.ks.well.feature_sleep.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Sleep(
    @PrimaryKey val id: Int? = null,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val day: LocalDate
)
