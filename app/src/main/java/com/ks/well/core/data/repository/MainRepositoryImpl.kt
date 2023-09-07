package com.ks.well.core.data.repository

import com.ks.well.core.domain.repository.MainRepository
import com.ks.well.feature_sleep.data.data_source.SleepDao
import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

class MainRepositoryImpl(
    private val sleepDao: SleepDao
): MainRepository {
    override suspend fun getSleepRecordsFromDay(dayTimestamp: LocalDateTime): Flow<List<Sleep>> {
        return sleepDao.getSleepRecordsFromDay(dayTimestamp)
    }
}