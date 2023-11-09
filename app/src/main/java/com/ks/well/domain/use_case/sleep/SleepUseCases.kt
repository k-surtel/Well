package com.ks.well.domain.use_case.sleep

data class SleepUseCases(
    val addSleepUseCase: AddSleepUseCase,
    val getSleepRecordsUseCase: GetSleepRecordsUseCase,
    val getSleepByIdUseCase: GetSleepByIdUseCase,
    val deleteSleepUseCase: DeleteSleepUseCase
)
