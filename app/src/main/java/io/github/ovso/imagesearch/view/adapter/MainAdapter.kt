package io.github.ovso.imagesearch.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.viewmodels.MainViewModel

class MainAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<MainViewHolder>() {

  private val items = ArrayList<CustomSearch.Item>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MainViewHolder {

    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(
    holder: MainViewHolder,
    position: Int
  ) = holder.bind(viewModel, position)

  override fun getItemCount() = items.size

  fun addAll(items: List<CustomSearch.Item> = ArrayList()) {
    this.items.addAll(items)
  }
}