package io.github.ovso.imagesearch.view.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.ovso.imagesearch.view.adapter.MainAdapter

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

  @JvmStatic
  @BindingAdapter("bind:imgRes")
  fun bindImageView(
    imageView: ImageView,
    url: String?
  ) {
    if (url != null) {
      if (!url.isNullOrEmpty()) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
      }
    }
  }
}