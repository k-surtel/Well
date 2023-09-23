package com.ks.well.feature_sleep.domain.use_case

import com.ks.well.feature_sleep.domain.model.Sleep
import com.ks.well.feature_sleep.domain.repository.SleepRepository
import java.time.LocalDate
import java.time.LocalDateTime

class AddSleepUseCase(
    private val repository: SleepRepository
) {
    suspend operator fun invoke(
        startDate: String,
        startTime: String,
        endDate: String,
        endTime: String

    ) {
        // todo: validate
        val sleep = parse(startDate, startTime, endDate, endTime)
        repository.insertSleep(sleep)
    }

    private fun parse(
        startDate: String,
        startTime: String,
        endDate: String,
        endTime: String
    ): Sleep {
        val startDateList = startDate.split("-")
        val startTimeList = startTime.split(".")
        val startTimestamp = LocalDateTime.of(
            startDateList[2].toInt(),
            startDateList[1].toInt(),
            startDateList[0].toInt(),
            startTimeList[0].toInt(),
            startTimeList[1].toInt())

        val endDateList = endDate.split("-")
        val endTimeList = endTime.split(".")
        val endTimestamp = LocalDateTime.of(
            endDateList[2].toInt(),
            endDateList[1].toInt(),
            endDateList[0].toInt(),
            endTimeList[0].toInt(),
            endTimeList[1].toInt())

        val day = LocalDate.of(
            endDateList[2].toInt(),
            endDateList[1].toInt(),
            endDateList[0].toInt())

        return Sleep(
            startTime = startTimestamp,
            endTime = endTimestamp,
            day = day
        )
    }
}