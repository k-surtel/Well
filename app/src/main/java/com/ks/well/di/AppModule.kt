package com.ks.well.di

import androidx.room.Room
import com.ks.well.core.data.data_source.WellDatabase
import com.ks.well.core.presentation.MainViewModel
import com.ks.well.feature_sleep.data.repository.SleepRepositoryImpl
import com.ks.well.feature_sleep.domain.repository.SleepRepository
import com.ks.well.feature_sleep.domain.use_case.AddSleepUseCase
import com.ks.well.feature_sleep.domain.use_case.GetSleepRecordsUseCase
import com.ks.well.feature_sleep.domain.use_case.SleepUseCases
import org.koin.android.ext.koin.androidApplication
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
}

val useCaseModule = module {
    single { AddSleepUseCase(get()) }
    single { GetSleepRecordsUseCase(get()) }
    single { SleepUseCases(get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}