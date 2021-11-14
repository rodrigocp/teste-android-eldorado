package br.com.rcp.domain.usecases.todo

import br.com.rcp.domain.repositories.TodoRepository
import br.com.rcp.domain.usecases.UseCase

class RemoveTodoItem(private val repository: TodoRepository) : UseCase<Long, Int>{
    override suspend fun invoke(param: Long): Int {
        return repository.remove(param)
    }
}