package br.com.rcp.todolist.presentation.features.todolist.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.rcp.domain.models.Todo
import br.com.rcp.todolist.R
import br.com.rcp.todolist.databinding.FragmentTodoListBinding
import br.com.rcp.todolist.presentation.adapters.RowItemAdapter
import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel
import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel.Companion.DEFAULT
import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel.Companion.FAILURE
import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel.Companion.SUCCESS
import kotlinx.android.synthetic.main.fragment_todo_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.time.LocalDateTime

class ListFragment : Fragment() {
    private val viewmodel by sharedViewModel<TodoViewModel>()

    private var _adapter: RowItemAdapter? = null
    private var _binding: FragmentTodoListBinding? = null

    private val adapter get() = _adapter!!
    private val binding get() = _binding!!

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel.collection.observe(this) {
            adapter.submitList(it)
        }

        viewmodel.inserted.observe(this) {
            if (it == SUCCESS) {
                viewmodel.collection.value?.size?.minus(1)?.let { last ->
                    adapter.notifyItemInserted(last)
                    adapter.notifyItemRangeChanged(last, viewmodel.count)
                    viewmodel.inserted.postValue(DEFAULT)
                }
            }

            if (it == FAILURE) {
                Log.e("INSERT", "Failed to execute query")
                viewmodel.inserted.postValue(DEFAULT)
            }
        }

        viewmodel.updated.observe(this) {
            if (it == SUCCESS) {
                adapter.notifyItemChanged(position)
                viewmodel.updated.postValue(DEFAULT)
            }

            if (it == FAILURE) {
                Log.e("UPDATE", "Failed to execute query")
                viewmodel.updated.postValue(DEFAULT)
            }
        }

        viewmodel.deleted.observe(this) {
            if (it == SUCCESS) {
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position, viewmodel.count)
                viewmodel.deleted.postValue(DEFAULT)
            }

            if (it == FAILURE) {
                Log.e("DELETE", "Failed to execute query")
                viewmodel.deleted.postValue(DEFAULT)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _adapter = RowItemAdapter(onItemClick, onLongItemClick)
        adapter.registerAdapterDataObserver(adapterDataObserver)
        list.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewmodel.find()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _adapter = null
    }

    private val onItemClick = { data: Todo, position: Int ->
        data.done = !data.done
        this.position = position
        viewmodel.update(data)
    }

    private val onLongItemClick = { data: Todo, position: Int ->
        showAlertDialog(data, position)
    }

    private val adapterDataObserver = object: RecyclerView.AdapterDataObserver() {
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            if (adapter.itemCount == 0) {
                empty.visibility = View.VISIBLE
                list.visibility = View.INVISIBLE
            } else {
                empty.visibility = View.INVISIBLE
                list.visibility = View.VISIBLE
            }
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            if (adapter.itemCount == 0) {
                empty.visibility = View.VISIBLE
                list.visibility = View.INVISIBLE
            } else {
                empty.visibility = View.INVISIBLE
                list.visibility = View.VISIBLE
            }
        }
    }

    private fun showAlertDialog(data: Todo, position: Int) {
        AlertDialog.Builder(context).apply {
            setTitle(R.string.delete_item_confirmation_title)
            setMessage(R.string.delete_item_confirmation_description)
            setNegativeButton(android.R.string.cancel, null)
            setPositiveButton(android.R.string.ok) { _, _ ->
                viewmodel.remove(data)
                this@ListFragment.position = position
            }
        }.show()
    }
}