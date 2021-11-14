package br.com.rcp.data.di

import androidx.room.Room
import br.com.rcp.data.source.local.Database
import br.com.rcp.data.source.local.Schema
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        single { Room.databaseBuilder(get(), Database::class.java, Schema.DB_NAME).allowMainThreadQueries().build() }
        single { get<Database>().todoDAO() }
    }
}