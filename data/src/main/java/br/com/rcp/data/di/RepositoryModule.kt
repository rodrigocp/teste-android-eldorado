package br.com.rcp.data.di

import br.com.rcp.data.repositories.TodoRepositoryImpl
import br.com.rcp.domain.repositories.TodoRepository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        factory<TodoRepository> { TodoRepositoryImpl(todoDAO = get()) }
    }
}