package io.github.ovso.imagesearch.view.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.view.base.IBind2
import io.github.ovso.imagesearch.viewmodels.MainViewModel
import kotlinx.android.extensions.LayoutContainer

class MainViewHolder(
  private var binding: ViewDataBinding,
  override val containerView: View?
) : RecyclerView.ViewHolder(containerView!!),
    LayoutContainer,
    IBind2<MainViewModel> {

  override fun bind(
    viewModel: MainViewModel,
    position: Int
  ) {
    println("bind = $position")
    var item = viewModel.mutableLiveData?.value?.get(position)
    var url = item?.pagemap?.cse_image?.first()?.src
    println("url = $url")
  }

  companion object {
    fun create(binding: ViewDataBinding): MainViewHolder {
      return MainViewHolder(binding, binding.root)
    }
  }
}