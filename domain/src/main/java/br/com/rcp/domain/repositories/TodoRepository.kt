package br.com.rcp.domain.repositories

import br.com.rcp.domain.models.Todo

interface TodoRepository {
    suspend fun find(): List<Todo>
    suspend fun find(param: Long): Todo
    suspend fun persist(param: Todo): Long
    suspend fun update(param: Todo): Int
    suspend fun remove(param: Long): Int
}