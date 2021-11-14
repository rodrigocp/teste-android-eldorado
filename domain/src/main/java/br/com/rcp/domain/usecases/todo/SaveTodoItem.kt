package br.com.rcp.domain.usecases.todo

import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.repositories.TodoRepository
import br.com.rcp.domain.usecases.UseCase

class SaveTodoItem(private val repository: TodoRepository) : UseCase<Todo, Long>{
    override suspend fun invoke(param: Todo): Long {
        return repository.persist(param)
    }
}