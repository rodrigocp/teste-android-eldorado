package br.com.rcp.todolist.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.rcp.todolist.R
import kotlinx.android.synthetic.main.row_item.view.*

class RowItem @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {
    var titleText: String? = ""
        set(value) {
            field = value
            title.text = value
        }

    var descriptionText: String? = ""
        set(value) {
            field = value
            description.text = value
        }

    var doneValue: Boolean? = false
        set(value) {
            field = value
            done.isChecked = value ?: false
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.row_item, this, true)
    }
}