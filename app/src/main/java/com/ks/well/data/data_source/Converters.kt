package com.ks.well.data.data_source

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun timestampToLocalDateTime(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it) }
    }

    @TypeConverter
    fun localDateTimeToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun timestampToLocalDate(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun localDateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }
}