package io.github.ovso.imagesearch.view.bindings

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomViewBindings {
    companion object {
        fun bindRecyclerViewAdapter(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        ) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
        }
    }
}