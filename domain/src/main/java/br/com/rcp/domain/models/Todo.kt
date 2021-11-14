package br.com.rcp.domain.models

import java.time.LocalDateTime

data class Todo(
    var identifier: Long? = null,
    var title: String,
    var description: String,
    var done: Boolean = false,
    var created: LocalDateTime = LocalDateTime.now()
)
