package io.github.ovso.imagesearch.view.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.view.base.IBind2
import io.github.ovso.imagesearch.viewmodels.MainViewModel
import kotlinx.android.extensions.LayoutContainer

class MainViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer,
    IBind2<MainViewModel> {
    override val containerView: View?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun bind(viewModel: MainViewModel, position: Int) {
        // 뷰모델의 데이터를 position 값으로 가져온다?
    }

    companion object {
        fun create(binding: ViewDataBinding): MainViewHolder {
            return MainViewHolder(binding)
        }
    }
}