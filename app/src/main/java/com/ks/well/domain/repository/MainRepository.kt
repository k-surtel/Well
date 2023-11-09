package com.ks.well.domain.repository

import com.ks.well.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface MainRepository {
    suspend fun getSleepRecordsFromDay(dayTimestamp: LocalDate): Flow<List<Sleep>>
}