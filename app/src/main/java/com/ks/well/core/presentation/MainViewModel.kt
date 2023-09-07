package com.ks.well.core.presentation

import androidx.lifecycle.ViewModel
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
class MainViewModel(
    private val sleepUseCases: SleepUseCases
): ViewModel() {
}