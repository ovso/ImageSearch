package io.github.ovso.imagesearch.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.R
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.view.base.IBind
import kotlinx.android.extensions.LayoutContainer

class MainViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer,
    IBind<CustomSearch.Item> {
    private var binding: ViewDataBinding? = null

    override fun bind(data: CustomSearch.Item) {

    }


    companion object {
        fun create(root: ViewGroup): MainViewHolder {
            val view = View.inflate(root.context, R.layout.item_main, root)
            return MainViewHolder(view)
        }

        fun create(binding: ViewDataBinding): MainViewHolder {
            return MainViewHolder(binding.root)
        }
    }
}