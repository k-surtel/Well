package com.ks.well.domain.use_case.sleep

import com.ks.well.domain.model.Sleep
import com.ks.well.domain.repository.SleepRepository

class GetSleepByIdUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(sleepId: Int): Sleep? {
        return repository.getSleepById(sleepId)
    }
}