package br.com.rcp.todolist.presentation.features.todolist.view

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.rcp.domain.models.Todo
import br.com.rcp.todolist.R
import br.com.rcp.todolist.databinding.DialogNewItemBinding
import br.com.rcp.todolist.presentation.features.todolist.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.dialog_new_item.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class IncludeItemDialog : DialogFragment() {
    private val viewmodel by sharedViewModel<TodoViewModel>()
    private var _binding: DialogNewItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogNewItemBinding.inflate(inflater, container, false)
        dialog?.apply {
            setTitle(R.string.new_item)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
    }

    override fun onResume() {
        super.onResume()

        DisplayMetrics().apply {
            activity?.windowManager?.defaultDisplay?.getMetrics(this)
            dialog?.window?.setLayout(widthPixels - 40, ActionBar.LayoutParams.WRAP_CONTENT)
        }
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        _binding = null
    }

    private fun setupButtons() {
        save.setOnClickListener {
            if (title.text?.trim().isNullOrEmpty()) {
                title.error = getString(R.string.title_cannot_be_empty)
            } else {
                viewmodel.save(Todo(title = title.text.toString(), description = description.text.toString()))
                dismiss()
            }
        }

        close.setOnClickListener {
            dismiss()
        }
    }
}