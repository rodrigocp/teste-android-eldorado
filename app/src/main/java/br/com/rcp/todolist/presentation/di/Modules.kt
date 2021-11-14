package br.com.rcp.todolist.presentation.di

import androidx.lifecycle.ViewModel
import br.com.rcp.data.di.DatabaseModule
import br.com.rcp.data.di.RepositoryModule
import br.com.rcp.domain.di.UseCaseModule

object Modules {
    val instances = listOf(
        DatabaseModule.module,
        RepositoryModule.module,
        UseCaseModule.module,
        ViewModelModule.module
    )
}