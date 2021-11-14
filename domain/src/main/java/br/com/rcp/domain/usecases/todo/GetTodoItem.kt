package br.com.rcp.domain.usecases.todo

import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.repositories.TodoRepository
import br.com.rcp.domain.usecases.UseCase

class GetTodoItem(private val repository: TodoRepository) : UseCase<Long, Todo>{
    override suspend fun invoke(param: Long): Todo {
        return repository.find(param)
    }
}