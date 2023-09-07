package com.ks.well.feature_sleep.domain.use_case

import com.ks.well.feature_sleep.domain.model.Sleep
import com.ks.well.feature_sleep.domain.repository.SleepRepository
import kotlinx.coroutines.flow.Flow

class GetSleepRecordsUseCase(
    private val repository: SleepRepository
) {
    operator fun invoke(): Flow<List<Sleep>> {
        return repository.getSleepRecords()
    }
}