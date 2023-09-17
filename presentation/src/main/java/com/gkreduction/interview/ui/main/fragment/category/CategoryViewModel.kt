package com.gkreduction.interview.ui.main.fragment.category

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableField
import com.gkreduction.interview.entity.Category
import com.gkreduction.interview.entity.DataInfo
import com.gkreduction.interview.utils.BaseAndroidViewModel
import com.gkreduction.interview.utils.getPriority

class CategoryViewModel(context: Context) :
    BaseAndroidViewModel(context.applicationContext as Application) {
    var categories = ObservableField<List<Category>>()

    fun setCategories(dataInfo: List<DataInfo>?) {
        if (dataInfo != null) {
            val set = HashSet<String>()
            for (data in dataInfo) {
                set.add(data.category)
            }

            val result = ArrayList<Category>()
            for (cat in set) {
                val category = Category(getPriority(cat), cat)
                result.add(category)
            }
            result.sortBy { it.id }
            categories.set(result)
        }
    }
}