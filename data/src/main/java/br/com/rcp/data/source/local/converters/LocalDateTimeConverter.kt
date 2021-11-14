package br.com.rcp.data.source.local.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {
    @TypeConverter
    fun toDate(string: String?): LocalDateTime? {
        return string?.let { LocalDateTime.parse(string) }
    }

    @TypeConverter
    fun toString(date: LocalDateTime?): String? {
        return date?.toString()
    }
}