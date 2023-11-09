package com.ks.well.data.repository

import com.ks.well.domain.repository.MainRepository
import com.ks.well.data.data_source.SleepDao
import com.ks.well.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class MainRepositoryImpl(
    private val sleepDao: SleepDao
): MainRepository {
    override suspend fun getSleepRecordsFromDay(dayTimestamp: LocalDate): Flow<List<Sleep>> {
        return sleepDao.getSleepRecordsFromDay(dayTimestamp)
    }
}