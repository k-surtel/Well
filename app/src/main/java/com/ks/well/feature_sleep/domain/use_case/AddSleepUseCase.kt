package com.ks.well.feature_sleep.domain.use_case

import com.ks.well.feature_sleep.domain.model.Sleep
import com.ks.well.feature_sleep.domain.repository.SleepRepository

class AddSleepUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(sleep: Sleep) {
        //todo: validation
        repository.insertSleep(sleep)
    }
}