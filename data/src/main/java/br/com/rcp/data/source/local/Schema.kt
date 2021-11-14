package br.com.rcp.data.source.local

object Schema {
    const val DB_NAME = "app_database"

    object Entity {
        object Todo {
            const val TABLE_NAME         = "todo"
            const val COLUMN_ID          = "id"
            const val COLUMN_TITLE       = "title"
            const val COLUMN_DESCRIPTION = "description"
            const val COLUMN_IS_DONE     = "is_done"
            const val COLUMN_CREATED_AT  = "created_at"

            object Query {
                const val DELETE_ALL     = "DELETE FROM $TABLE_NAME"
                const val DELETE_BY_ID   = "DELETE FROM $TABLE_NAME WHERE $COLUMN_ID = :$COLUMN_ID"
                const val SELECT_ALL     = "SELECT * FROM $TABLE_NAME"
                const val SELECT_BY_ID   = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = :$COLUMN_ID"
            }
        }
    }
}