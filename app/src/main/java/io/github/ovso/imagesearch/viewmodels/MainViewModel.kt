package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.service.repository.CustomSearchRequest
import io.github.ovso.imagesearch.utils.Schedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel : BaseViewModel() {

  var name: ObservableField<String>? = null
  var selected: MutableLiveData<CustomSearch.Item>? = null
  var customSearchRequest: CustomSearchRequest? = null
  var schedulers: Schedulers? = null
  var customSearchRe: CustomSearchRequest? = null

  fun onClick(v: View) {

  }

  fun init() {
    name = ObservableField("ㅋㅋㅋㅋㅋㅋㅋㅋ");
    selected = MutableLiveData()
    schedulers = Schedulers()
    customSearchRequest = CustomSearchRequest()
  }

  val onQueryTextChange = object : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?): Boolean {
      return false;
    }

    override fun onQueryTextChange(query: String?): Boolean {
      clearDisposable()
      if (!query.isNullOrEmpty()) {
        customSearchRequest!!.customSearch(query)
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

      }

      override fun onSubscribe(d: Disposable) {
        addDisposable(d)
      }

      override fun onError(e: Throwable) {
        Timber.e(e)
      }
    }
  }
}