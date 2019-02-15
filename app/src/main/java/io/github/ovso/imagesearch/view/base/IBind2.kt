package io.github.ovso.imagesearch.view.base

interface IBind2<T> {
    fun bind(viewModel: T, position:Int)
}