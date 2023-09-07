package com.ks.well.feature_sleep.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sleep(
    @PrimaryKey val id: Int? = null,
    val startTimestamp: Long,
    val endTimestamp: Long,
    val duration: Float
)
