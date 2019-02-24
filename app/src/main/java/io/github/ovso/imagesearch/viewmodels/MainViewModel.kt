package io.github.ovso.imagesearch.viewmodels

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.service.model.CustomSearch.Item
import io.github.ovso.imagesearch.service.model.CustomSearch.Queries
import io.github.ovso.imagesearch.service.repository.CustomSearchRequest
import io.github.ovso.imagesearch.utils.Schedulers
import io.github.ovso.imagesearch.view.adapter.MainAdapter
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel : BaseViewModel() {

  var selected: MutableLiveData<CustomSearch.Item>? = null
  var mutableLiveData: MutableLiveData<List<CustomSearch.Item>>? = null
  var customSearchRequest: CustomSearchRequest? = null
  var schedulers: Schedulers? = null
  var adapter: MainAdapter? = null
  var error: MutableLiveData<Int>? = null
  var loading: MutableLiveData<Int>? = null
  var showEmpty: MutableLiveData<Int>? = null
  var queries: Queries? = null
  var startIndex: Int? = null
  var q: String? = null

  fun init() {
    selected = MutableLiveData()
    schedulers = Schedulers()
    customSearchRequest = CustomSearchRequest()
    mutableLiveData = MutableLiveData()
    adapter = MainAdapter(this)
    error = MutableLiveData()
    loading = MutableLiveData()
    showEmpty = MutableLiveData()
    startIndex = 1;
  }

  val onQueryTextChange = object : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?): Boolean {
      return false;
    }

    override fun onQueryTextChange(query: String?): Boolean {
      println("onQueryTextChange = $query")
      clearDisposable()
      if (!query.isNullOrEmpty()) {
        q = query
        customSearchRequest!!.customSearch(startIndex!!, query)
            .delay(1, TimeUnit.SECONDS)
            .subscribeOn(schedulers!!.io())
            .observeOn(schedulers!!.ui())
            .subscribe(getObserver())
      } else {
        Timber.d("onQueryTextChange = null or empty")
      }

      return false
    }
  }

  private fun getObserver(): SingleObserver<CustomSearch.Result> {
    return object : SingleObserver<CustomSearch.Result> {
      override fun onSuccess(t: CustomSearch.Result) {
        mutableLiveData?.value = t.items
        queries = t.queries
        startIndex = t.queries.nextPage.first()
            .startIndex
      }

      override fun onSubscribe(d: Disposable) {
        addDisposable(d)
      }

      override fun onError(e: Throwable) {
        println("onError = $e")
      }
    }
  }

  fun getItem(position: Int) = mutableLiveData?.value?.get(position)

  fun getImageUrl(position: Int): String? {
    return mutableLiveData?.value?.get(position)
        ?.pagemap?.cse_image?.first()
        ?.src
  }

  fun setItemsInAdapter(it: List<Item> = ArrayList()) {
    adapter?.addAll(it)
    adapter?.notifyDataSetChanged()
  }

  fun onNextClick() {
    if (!q.isNullOrEmpty()) {
      onQueryTextChange.onQueryTextChange(q)
    }

  }
}