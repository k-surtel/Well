package com.ks.well.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ks.well.data.data_source.SleepDao
import com.ks.well.domain.model.Sleep

@Database(
    entities = [Sleep::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WellDatabase: RoomDatabase() {
    abstract val sleepDao: SleepDao

    companion object {
        const val DATABASE_NAME = "well_db"
    }
}