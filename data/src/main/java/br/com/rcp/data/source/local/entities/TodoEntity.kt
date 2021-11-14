package br.com.rcp.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.rcp.data.source.local.Schema
import java.time.LocalDateTime

@Entity(tableName = Schema.Entity.Todo.TABLE_NAME)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Schema.Entity.Todo.COLUMN_ID)
    var identifier: Long? = null,

    @ColumnInfo(name = Schema.Entity.Todo.COLUMN_TITLE)
    var title: String = "",

    @ColumnInfo(name = Schema.Entity.Todo.COLUMN_DESCRIPTION)
    val description: String = "",

    @ColumnInfo(name = Schema.Entity.Todo.COLUMN_IS_DONE)
    var done: Boolean = false,

    @ColumnInfo(name = Schema.Entity.Todo.COLUMN_CREATED_AT)
    val created: LocalDateTime = LocalDateTime.now(),
)