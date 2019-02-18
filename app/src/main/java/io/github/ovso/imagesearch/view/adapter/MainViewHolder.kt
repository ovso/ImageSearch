package io.github.ovso.imagesearch.view.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.viewmodels.MainViewModel

class MainViewHolder(
  var binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(
    viewModel: MainViewModel,
    position: Int
  ) {
    binding.setVariable(BR.vm, viewModel)
    binding.setVariable(BR.position, position)
  }

  companion object {
    fun create(binding: ViewDataBinding): MainViewHolder {
      return MainViewHolder(binding)
    }
  }
}