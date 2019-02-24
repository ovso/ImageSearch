package io.github.ovso.imagesearch.view.adapter

import androidx.paging.PositionalDataSource
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.service.model.CustomSearch.Item

class ItemDataSource : PositionalDataSource<CustomSearch.Item>() {

  fun computeCount(): Int {
    TODO(
        "실제 데이터의 사이즈를 반환"
    )
  }

  private fun loadRangeInternal(
    startPosition: Int,
    loadCount: Int
  ): List<Item> {
    val totalCount = computeCount()

    TODO(
        "특정 포지션으로부터 원하는 만큼의 데이터를 이곳에서 로드"
    )
  }

  override fun loadRange(
    params: LoadRangeParams,
    callback: LoadRangeCallback<Item>
  ) {

  }

  override fun loadInitial(
    params: LoadInitialParams,
    callback: LoadInitialCallback<Item>
  ) {
    val totalCount = computeCount()
    val position = PositionalDataSource.computeInitialLoadPosition(params, totalCount)
    val loadSize = PositionalDataSource.computeInitialLoadSize(params, position, totalCount)
    callback.onResult(loadRangeInternal(position, loadSize), position, totalCount)
  }

}