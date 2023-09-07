package com.ks.well.feature_sleep.domain.repository

import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow

interface SleepRepository {

    suspend fun insertSleep(sleep: Sleep)

    fun getSleepRecords(): Flow<List<Sleep>>
}