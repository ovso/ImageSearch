package io.github.ovso.imagesearch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.R
import io.github.ovso.imagesearch.viewmodels.MainViewModel

class MainViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

  fun bind(
    viewModel: MainViewModel,
    position: Int
  ) {
    binding.setVariable(BR.vm, viewModel)
    binding.setVariable(BR.position, position)
  }

  companion object {
    fun create(parent: ViewGroup): MainViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
      val binding: ViewDataBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.item_main, parent, false)
      return MainViewHolder(binding)
    }
  }
}