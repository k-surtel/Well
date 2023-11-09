package com.ks.well.domain.use_case

import com.ks.well.domain.model.Sleep
import com.ks.well.domain.repository.SleepRepository
import java.time.Duration
import java.time.LocalDateTime

class AddSleepUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(id: Int?, startDateTime: LocalDateTime, endDateTime: LocalDateTime, quality: Int) {
        if (areDatesValid(startDateTime, endDateTime)) { // todo check if sleep in this time is already in db
            val sleep = getSleepInstance(id, startDateTime, endDateTime, quality)
            repository.insertSleep(sleep)
        } else {
            // todo throw exception
        }
    }

    private fun areDatesValid(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Boolean {
        return endDateTime.isAfter(startDateTime)
    }

    private fun getSleepInstance(id: Int?, startDateTime: LocalDateTime, endDateTime: LocalDateTime, quality: Int): Sleep {
        val duration = Duration.between(startDateTime, endDateTime)
        return Sleep(
            id = id,
            startDateTime = startDateTime,
            endDateTime = endDateTime,
            duration = duration.toMinutes(),
            day = endDateTime.toLocalDate(),
            quality = quality
        )
    }
}