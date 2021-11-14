package br.com.rcp.data.source.local.dao

import androidx.room.*
import br.com.rcp.data.source.local.Schema
import br.com.rcp.data.source.local.entities.TodoEntity

@Dao
interface TodoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persist(entity: TodoEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: TodoEntity): Int

    @Query(Schema.Entity.Todo.Query.DELETE_BY_ID)
    suspend fun remove(id: Long): Int

    @Query(Schema.Entity.Todo.Query.DELETE_ALL)
    suspend fun remove(): Int

    @Query(Schema.Entity.Todo.Query.SELECT_ALL)
    suspend fun find(): List<TodoEntity>

    @Query(Schema.Entity.Todo.Query.SELECT_BY_ID)
    suspend fun find(id: Long): TodoEntity
}