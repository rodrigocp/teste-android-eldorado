package br.com.rcp.data.repositories

import br.com.rcp.data.source.local.dao.TodoDAO
import br.com.rcp.data.source.local.mapper.TodoMapper
import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.repositories.TodoRepository

class TodoRepositoryImpl(private val todoDAO: TodoDAO) : TodoRepository {
    override suspend fun find(): List<Todo> {
        return todoDAO.find().map(TodoMapper::toDomain)
    }

    override suspend fun find(param: Long): Todo {
        return TodoMapper.toDomain(todoDAO.find(param))
    }

    override suspend fun persist(param: Todo): Long {
        return todoDAO.persist(TodoMapper.toEntity(param))
    }

    override suspend fun update(param: Todo): Int {
        return todoDAO.update(TodoMapper.toEntity(param))
    }

    override suspend fun remove(param: Long): Int {
        return todoDAO.remove(param)
    }
}