package com.gkreduction.roadmap.ui.main.fragment.category.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gkreduction.roadmap.entity.Category

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("itemsCategory", "listenerCategory", requireAll = false)
    fun setListener(
        recyclerView: RecyclerView,
        items: List<Category>?,
        clickItem: AdapterCategory.ListenerList?
    ) {

        items?.let {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter =
                AdapterCategory(it, clickItem)
        }
    }

}