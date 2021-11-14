package br.com.rcp.todolist.presentation.features.todolist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.rcp.todolist.R
import br.com.rcp.todolist.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {
    private val dialog by lazy { IncludeItemDialog() }
    private val host by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_todo) as NavHostFragment }
    private val controller by lazy { host.navController }
    private val bar by lazy { AppBarConfiguration(controller.graph) }
    private val binding by lazy { ActivityTodoBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(controller, bar)

        binding.fab.setOnClickListener { view ->
            dialog.show(supportFragmentManager, "fragment_include_item")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_todo)
        return navController.navigateUp(bar) || super.onSupportNavigateUp()
    }
}