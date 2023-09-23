package com.ks.well.core.domain.use_case

import com.ks.well.core.domain.repository.MainRepository
import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetSleepRecordsFromDayUseCase(
private val repository: MainRepository
) {
    suspend operator fun invoke(day: LocalDate): Flow<List<Sleep>> {
        return repository.getSleepRecordsFromDay(day)
    }
}