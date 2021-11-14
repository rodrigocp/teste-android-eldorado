package br.com.rcp.todolist.presentation.di

import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel {
            TodoViewModel(getTodoList = get(), saveTodoItem = get(), updateTodoItem = get(), removeTodoItem = get())
        }
    }
}