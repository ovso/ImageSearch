package io.github.ovso.imagesearch.view.base

import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer, IBind<T> {

    protected var data: T? = null

    @CallSuper
    override fun bind(data: T) {
        this.data = data
    }

}