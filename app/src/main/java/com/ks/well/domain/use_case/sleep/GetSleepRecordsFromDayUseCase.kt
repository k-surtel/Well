package com.ks.well.domain.use_case.sleep

import com.ks.well.domain.repository.MainRepository
import com.ks.well.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetSleepRecordsFromDayUseCase(
private val repository: MainRepository
) {
    suspend operator fun invoke(day: LocalDate): Flow<List<Sleep>> {
        return repository.getSleepRecordsFromDay(day)
    }
}