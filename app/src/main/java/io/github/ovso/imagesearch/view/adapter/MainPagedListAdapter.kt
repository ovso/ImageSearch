package io.github.ovso.imagesearch.view.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.viewmodels.MainViewModel

class MainPagedListAdapter(private var viewModel: MainViewModel) : PagedListAdapter<CustomSearch.Item, MainViewHolder>(
    itemDiffCallback
) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MainViewHolder {
    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(
    holder: MainViewHolder,
    position: Int
  ) {
    holder.bind(viewModel, position)
  }

  companion object {
    private val itemDiffCallback = object : DiffUtil.ItemCallback<CustomSearch.Item>() {
      override fun areItemsTheSame(
        oldItem: CustomSearch.Item,
        newItem: CustomSearch.Item
      ): Boolean {
        //return oldItem.id == newItem.id
        return oldItem.title.equals(newItem.title)
      }

      override fun areContentsTheSame(
        oldItem: CustomSearch.Item,
        newItem: CustomSearch.Item
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}