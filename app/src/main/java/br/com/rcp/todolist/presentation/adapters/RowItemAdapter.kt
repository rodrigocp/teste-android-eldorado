package br.com.rcp.todolist.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.rcp.domain.models.Todo
import br.com.rcp.todolist.databinding.ListItemBinding
import kotlinx.android.synthetic.main.row_item.view.*

class RowItemAdapter(private val onClickListener: (data: Todo, position: Int) -> Unit, private val onLongClickListener: (data: Todo, position: Int) -> Unit) : ListAdapter<Todo, RowItemAdapter.ViewHolder>(RowItemAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    private companion object : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(old: Todo, new: Todo): Boolean {
            return old == new
        }

        override fun areContentsTheSame(old: Todo, new: Todo): Boolean {
            return old == new
        }
    }

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Todo, position: Int) {
            binding.root.run {
                titleText = data.title
                descriptionText = data.description
                doneValue = data.done
                itemView.isLongClickable = true

                done.setOnClickListener {
                    onClickListener(data, position)
                }

                itemView.setOnClickListener {
                    onClickListener(data, position)
                }

                itemView.setOnLongClickListener {
                    onLongClickListener(data, position)
                    true
                }
            }
        }
    }
}