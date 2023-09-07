package com.ks.well.feature_sleep.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ks.well.feature_sleep.domain.model.Sleep
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSleep(sleep: Sleep)

    @Query("SELECT * FROM sleep")
    fun getSleepRecords(): Flow<List<Sleep>>
}