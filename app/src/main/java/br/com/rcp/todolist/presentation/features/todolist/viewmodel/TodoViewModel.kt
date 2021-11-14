package br.com.rcp.todolist.presentation.features.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import br.com.rcp.domain.models.Todo
import br.com.rcp.domain.usecases.todo.GetTodoList
import br.com.rcp.domain.usecases.todo.RemoveTodoItem
import br.com.rcp.domain.usecases.todo.SaveTodoItem
import br.com.rcp.domain.usecases.todo.UpdateTodoItem
import br.com.rcp.todolist.presentation.features.common.BaseViewModel

class TodoViewModel(private val getTodoList: GetTodoList, private val saveTodoItem: SaveTodoItem, private val updateTodoItem: UpdateTodoItem, private val removeTodoItem: RemoveTodoItem) : BaseViewModel() {
    val collection by lazy { MutableLiveData<MutableList<Todo>>() }
    val updated by lazy { MutableLiveData(DEFAULT) }
    val inserted by lazy { MutableLiveData(DEFAULT) }
    val deleted by lazy { MutableLiveData(DEFAULT) }

    val count: Int get() = collection.value?.size ?: 0

    fun save(data: Todo) {
        doAsyncTask {
            saveTodoItem.invoke(data).run {
                if (this != 0L) {
                    data.identifier = this
                    collection.value?.add(data)
                    inserted.postValue(SUCCESS)
                } else {
                    inserted.postValue(FAILURE)
                }
            }
        }
    }

    fun find() {
        doAsyncTask {
            getTodoList.invoke(null).toMutableList().run {
                collection.postValue(this)
            }
        }
    }

    fun update(data: Todo) {
        doAsyncTask {
            updateTodoItem.invoke(data).run {
                if (this != 0) {
                    updated.postValue(SUCCESS)
                } else {
                    updated.postValue(FAILURE)
                }
            }
        }
    }

    fun remove(data: Todo) {
        doAsyncTask {
            data.identifier?.let {
                removeTodoItem.invoke(it).run {
                    if (this != 0) {
                        collection.value?.remove(data)
                        deleted.postValue(SUCCESS)
                    } else {
                        deleted.postValue(FAILURE)
                    }
                }
            }
        }
    }

    companion object {
        const val SUCCESS = 1;
        const val FAILURE = -1;
        const val DEFAULT = 0;
    }
}