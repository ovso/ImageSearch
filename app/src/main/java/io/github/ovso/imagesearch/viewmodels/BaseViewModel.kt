package io.github.ovso.imagesearch.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onCleared() {
        clearDisposable()
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }
}