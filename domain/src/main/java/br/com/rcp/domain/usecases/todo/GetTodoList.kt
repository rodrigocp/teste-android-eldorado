package br.com.rcp.domain.usecases.todo

import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.repositories.TodoRepository
import br.com.rcp.domain.usecases.UseCase

class GetTodoList(private val repository: TodoRepository) : UseCase<Any?, List<Todo>>{
    override suspend fun invoke(param: Any?): List<Todo> {
        return repository.find()
    }
}