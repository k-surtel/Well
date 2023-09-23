package com.ks.well.core.domain.repository

import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface MainRepository {
    suspend fun getSleepRecordsFromDay(dayTimestamp: LocalDate): Flow<List<Sleep>>
}