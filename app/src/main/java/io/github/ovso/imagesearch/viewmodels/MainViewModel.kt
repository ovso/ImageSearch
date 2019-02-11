package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.ObservableField
import io.github.ovso.imagesearch.service.model.CustomSearch
import io.github.ovso.imagesearch.service.repository.CustomSearchRequest
import io.github.ovso.imagesearch.utils.Schedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel : BaseViewModel() {

    val name = ObservableField("ㅇㅇㅇㅇ")
    val customSearchRequest = CustomSearchRequest()
    val schedulers = Schedulers()
    fun onClick(v: View) {
        name.set("크크크크")
    }


    val onQueryTextChange = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false;
        }

        override fun onQueryTextChange(query: String?): Boolean {
            clearDisposable()
            if (!query.isNullOrEmpty()) {
                customSearchRequest.customSearch(query)
                    .delay(1, TimeUnit.SECONDS)
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())
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