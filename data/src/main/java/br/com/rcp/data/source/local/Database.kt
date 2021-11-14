package br.com.rcp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.rcp.data.source.local.converters.LocalDateTimeConverter
import br.com.rcp.data.source.local.dao.TodoDAO
import br.com.rcp.data.source.local.entities.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = true)
@TypeConverters(LocalDateTimeConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun todoDAO(): TodoDAO
}