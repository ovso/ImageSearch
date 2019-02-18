package io.github.ovso.imagesearch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.R
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.viewmodels.MainViewModel

class MainAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<MainViewHolder>() {

  private val items = ArrayList<CustomSearch.Item>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MainViewHolder {

    val layoutInflater = LayoutInflater.from(parent.context)
    val binding: ViewDataBinding =
      DataBindingUtil.inflate(layoutInflater, R.layout.item_main, parent, false)

    return MainViewHolder.create(binding)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(
    holder: MainViewHolder,
    position: Int
  ) {
    holder.bind(viewModel, position);
  }

  fun addAll(items: List<CustomSearch.Item> = ArrayList()) {
    this.items.addAll(items)
  }
}