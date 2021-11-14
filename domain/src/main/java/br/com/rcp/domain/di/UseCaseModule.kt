package br.com.rcp.domain.di

import br.com.rcp.domain.usecases.todo.*
import org.koin.dsl.module

object UseCaseModule {
    val module = module {
        factory { GetTodoItem(repository = get()) }
        factory { GetTodoList(repository = get()) }
        factory { SaveTodoItem(repository = get()) }
        factory { UpdateTodoItem(repository = get()) }
        factory { RemoveTodoItem(repository = get()) }
    }
}