package com.ks.well.domain.repository

import com.ks.well.domain.model.Sleep
import kotlinx.coroutines.flow.Flow

interface SleepRepository {

    suspend fun insertSleep(sleep: Sleep)

    fun getSleepRecords(): Flow<List<Sleep>>

    suspend fun getSleepById(sleepId: Int): Sleep?

    suspend fun deleteSleep(sleep: Sleep)
}