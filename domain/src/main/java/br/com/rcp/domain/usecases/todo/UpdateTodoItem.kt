package br.com.rcp.domain.usecases.todo

import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.repositories.TodoRepository
import br.com.rcp.domain.usecases.UseCase

class UpdateTodoItem(private val repository: TodoRepository) : UseCase<Todo, Int>{
    override suspend fun invoke(param: Todo): Int {
        return repository.update(param)
    }
}