package br.com.rcp.todolist

import android.app.Application
import br.com.rcp.todolist.presentation.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@TodoApplication)
            modules(Modules.instances)
        }
    }
}