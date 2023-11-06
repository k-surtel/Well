package com.ks.well.di

import androidx.room.Room
import com.ks.well.core.data.data_source.WellDatabase
import com.ks.well.core.data.repository.MainRepositoryImpl
import com.ks.well.core.domain.repository.MainRepository
import com.ks.well.core.domain.use_case.GetSleepRecordsFromDayUseCase
import com.ks.well.core.domain.use_case.MainUseCases
import com.ks.well.core.presentation.MainViewModel
import com.ks.well.feature_sleep.data.repository.SleepRepositoryImpl
import com.ks.well.feature_sleep.domain.repository.SleepRepository
import com.ks.well.feature_sleep.domain.use_case.AddSleepUseCase
import com.ks.well.feature_sleep.domain.use_case.GetSleepRecordsUseCase
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
import com.ks.well.feature_sleep.presentation.add_edit_sleep.AddEditSleepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WellDatabase::class.java,
            WellDatabase.DATABASE_NAME
        ).build()
    }

    single { get<WellDatabase>().sleepDao }
}

val repositoryModule = module {
    single<SleepRepository> { SleepRepositoryImpl(get()) }
    single<MainRepository> { MainRepositoryImpl(get()) }
}

val useCaseModule = module {
    single {GetSleepRecordsFromDayUseCase(get())}
    single { MainUseCases(get()) }

    single { AddSleepUseCase(get()) }
    single { GetSleepRecordsUseCase(get()) }
    single { SleepUseCases(get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { AddEditSleepViewModel(get(), get()) }
}