package com.ks.well.di

import androidx.room.Room
import com.ks.well.data.data_source.WellDatabase
import com.ks.well.data.repository.MainRepositoryImpl
import com.ks.well.domain.repository.MainRepository
import com.ks.well.domain.use_case.sleep.GetSleepRecordsFromDayUseCase
import com.ks.well.domain.use_case.MainUseCases
import com.ks.well.presentation.main.MainViewModel
import com.ks.well.data.repository.SleepRepositoryImpl
import com.ks.well.domain.repository.SleepRepository
import com.ks.well.domain.use_case.sleep.AddSleepUseCase
import com.ks.well.domain.use_case.sleep.DeleteSleepUseCase
import com.ks.well.domain.use_case.sleep.GetSleepByIdUseCase
import com.ks.well.domain.use_case.sleep.GetSleepRecordsUseCase
import com.ks.well.domain.use_case.sleep.SleepUseCases
import com.ks.well.presentation.add_edit_sleep.AddEditSleepViewModel
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
    single { GetSleepRecordsFromDayUseCase(get()) }
    single { MainUseCases(get()) }

    single { AddSleepUseCase(get()) }
    single { GetSleepRecordsUseCase(get()) }
    single { GetSleepByIdUseCase(get()) }
    single { DeleteSleepUseCase(get()) }
    single { SleepUseCases(get(), get(), get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { AddEditSleepViewModel(get(), get()) }
}