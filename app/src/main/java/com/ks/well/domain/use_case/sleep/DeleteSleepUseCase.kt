package com.ks.well.domain.use_case.sleep

import com.ks.well.domain.model.Sleep
import com.ks.well.domain.repository.SleepRepository

class DeleteSleepUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(sleep: Sleep) {
        repository.deleteSleep(sleep)
    }
}