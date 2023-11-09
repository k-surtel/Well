package com.ks.well.data.repository

import com.ks.well.data.data_source.SleepDao
import com.ks.well.domain.model.Sleep
import com.ks.well.domain.repository.SleepRepository
import kotlinx.coroutines.flow.Flow

class SleepRepositoryImpl(
    private val dao: SleepDao
): SleepRepository {
    override suspend fun insertSleep(sleep: Sleep) {
        dao.insertSleep(sleep)
    }

    override fun getSleepRecords(): Flow<List<Sleep>> {
        return dao.getSleepRecords()
    }
}