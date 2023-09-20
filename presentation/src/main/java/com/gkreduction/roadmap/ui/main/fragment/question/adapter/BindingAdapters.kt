package com.gkreduction.roadmap.ui.main.fragment.question.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gkreduction.roadmap.entity.Question

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("itemsQuestion", "listenerQuestion", requireAll = false)
    fun setListener(
        recyclerView: RecyclerView,
        items: List<Question>?,
        clickItem: QuestionAdapter.ListenerList?,
    ) {
        items?.let {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = QuestionAdapter(it, clickItem)
        }
    }

}