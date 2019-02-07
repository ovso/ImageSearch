package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.github.ovso.imagesearch.service.repository.CustomSearchRequest
import io.github.ovso.imagesearch.utils.Schedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

class MainViewModel : ViewModel() {

    val name = ObservableField("ㅇㅇㅇㅇ")
    val customSearchRequest = CustomSearchRequest()
    val schedulers = Schedulers()
    val compositeDisposable = CompositeDisposable()
    fun onClick(v: View) {
        name.set("크크크크")
    }


    val onQueryTextChange = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false;
        }

        override fun onQueryTextChange(query: String?): Boolean {
            customSearchRequest.customSearch(query!!)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe(getObserver())

            return false
        }
    }

    private fun getObserver(): SingleObserver<Any> {
        return object : SingleObserver<Any> {
            override fun onSuccess(t: Any) {
                Timber.d("onSuccess = %s", t.toString())
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }

            override fun onError(e: Throwable) {
                Timber.e(e)
            }
        }
    }
}