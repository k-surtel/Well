package com.ks.well.core.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ks.well.feature_sleep.data.data_source.SleepDao
import com.ks.well.feature_sleep.domain.model.Sleep

@Database(
    entities = [Sleep::class],
    version = 1
)
abstract class WellDatabase: RoomDatabase() {
    abstract val sleepDao: SleepDao

    companion object {
        const val DATABASE_NAME = "well_db"
    }
}