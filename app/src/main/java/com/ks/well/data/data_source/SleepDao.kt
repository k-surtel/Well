package com.ks.well.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.ks.well.data.data_source.Converters
import com.ks.well.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
@TypeConverters(Converters::class)
interface SleepDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSleep(sleep: Sleep)

    @Query("SELECT * FROM sleep")
    fun getSleepRecords(): Flow<List<Sleep>>

    @Query("SELECT * FROM sleep WHERE day = :day")
    fun getSleepRecordsFromDay(day: LocalDate): Flow<List<Sleep>>

    @Query("SELECT * FROM sleep WHERE id = :id")
    suspend fun getSleepById(id: Int): Sleep?

    @Delete
    suspend fun deleteSleep(sleep: Sleep)
}