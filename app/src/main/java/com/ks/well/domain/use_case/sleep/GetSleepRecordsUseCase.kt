package com.ks.well.domain.use_case.sleep

import com.ks.well.domain.model.Sleep
import com.ks.well.domain.repository.SleepRepository
import kotlinx.coroutines.flow.Flow

class GetSleepRecordsUseCase(
    private val repository: SleepRepository
) {
    operator fun invoke(): Flow<List<Sleep>> {
        return repository.getSleepRecords()
    }
}