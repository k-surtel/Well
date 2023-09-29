package com.ks.well.feature_sleep.domain.use_case

import com.ks.well.feature_sleep.domain.model.Sleep
import com.ks.well.feature_sleep.domain.repository.SleepRepository
import java.time.Duration
import java.time.LocalDateTime

class AddSleepUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(startDateTime: LocalDateTime, endDateTime: LocalDateTime) {
        if (areDatesValid(startDateTime, endDateTime)) {
            val sleep = getSleepInstance(startDateTime, endDateTime)
            repository.insertSleep(sleep)
        } else {
            // todo throw exception
        }
    }

    private fun areDatesValid(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Boolean {
        return endDateTime.isAfter(startDateTime)
    }

    private fun getSleepInstance(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Sleep {
        val duration = Duration.between(startDateTime, endDateTime)
        return Sleep(
            startDateTime = startDateTime,
            endDateTime = endDateTime,
            duration = duration.toHours(),
            day = endDateTime.toLocalDate()
        )
    }
}