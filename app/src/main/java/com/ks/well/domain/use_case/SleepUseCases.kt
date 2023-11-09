package com.ks.well.domain.use_case

data class SleepUseCases(
    val addSleepUseCase: AddSleepUseCase,
    val getSleepRecordsUseCase: GetSleepRecordsUseCase,
    val getSleepByIdUseCase: GetSleepByIdUseCase
)
