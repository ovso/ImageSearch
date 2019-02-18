package io.github.ovso.imagesearch.view.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object AdapterBindings {
  @JvmStatic
  @BindingAdapter("setAdapter")
  fun bindRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: MainAdapter
  ) {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = adapter
  }
}