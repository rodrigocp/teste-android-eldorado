package br.com.rcp.data.source.local.mapper

import br.com.rcp.data.source.local.entities.TodoEntity
import br.com.rcp.domain.models.Todo

object TodoMapper : Mapper<TodoEntity, Todo> {
    override fun toDomain(entity: TodoEntity): Todo {
        return Todo(entity.identifier, entity.title, entity.description, entity.done, entity.created)
    }

    override fun toEntity(domain: Todo): TodoEntity {
        return TodoEntity(domain.identifier, domain.title, domain.description, domain.done, domain.created)
    }
}