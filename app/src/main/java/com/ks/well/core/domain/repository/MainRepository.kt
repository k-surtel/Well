package com.ks.well.core.domain.repository

import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface MainRepository {

    suspend fun getSleepRecordsFromDay(dayTimestamp: LocalDateTime): Flow<List<Sleep>>
}