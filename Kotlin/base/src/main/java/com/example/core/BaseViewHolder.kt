package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:37
 * description：
 */
abstract  class BaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    private  val viewHashMap = HashMap<Int,View>()

    protected open fun <T : View> getView(@IdRes id: Int): T? {
        var view:View? = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as? T
    }

    protected open fun setText(@IdRes id: Int, text: String?) {
        (getView<TextView>(id))?.text = text
    }

}