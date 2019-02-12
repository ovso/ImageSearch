package io.github.ovso.imagesearch.view.adapter

import android.view.View
import android.view.ViewGroup
import io.github.ovso.imagesearch.R
import io.github.ovso.imagesearch.view.base.BaseViewHolder

class MainViewHolder(override val containerView: View?) : BaseViewHolder<Any>(containerView!!) {
    override fun bind(data: Any) {
        this.data = data
    }


    companion object {
        fun create(root: ViewGroup): MainViewHolder {
            val view = View.inflate(root.context, R.layout.item_main, root)
            return MainViewHolder(view)
        }
    }
}