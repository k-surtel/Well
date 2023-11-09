package com.ks.well.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Sleep(
    @PrimaryKey val id: Int? = null,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val duration: Long,
    val day: LocalDate,
    val quality: Int
)
