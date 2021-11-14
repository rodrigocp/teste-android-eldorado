package br.com.rcp.todolist.presentation.features.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

abstract class BaseViewModel : ViewModel() {
    private var _loading: MutableLiveData<Boolean>? = null
    private var _failure: MutableLiveData<String>? = null

    val loading: LiveData<Boolean> get() = _loading!!
    val failure: LiveData<String> get() = _failure!!

    init {
        _loading = MutableLiveData()
        _failure = MutableLiveData()
    }

    override fun onCleared() {
        super.onCleared()
        _loading = null
        _failure = null
    }

    protected suspend fun setFailureMessage(message: String) {
        withContext(Dispatchers.Main) {
            _failure?.apply { postValue(message) }
        }
    }

    protected suspend fun setLoading(enable: Boolean) {
        withContext(Dispatchers.Main) {
            _loading?.apply { postValue(enable) }
        }
    }

    fun doAsyncTask(loading: Boolean = true, failure: Boolean = true, dispatcher: CoroutineDispatcher = Dispatchers.IO, task: suspend () -> Unit = { }) {
        viewModelScope.launch(dispatcher) {
            if (loading) {
                setLoading(true)
            }

            try {
                task()
            } catch (e: Exception) {
                if (failure) {
                    e.message?.let { setFailureMessage(it) }
                }
            } finally {
                if (loading) {
                    setLoading(false)
                }
            }
        }
    }
}