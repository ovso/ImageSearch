package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.github.ovso.imagesearch.service.repository.ImageRequest
import io.github.ovso.imagesearch.utils.Schedulers
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class MainViewModel : ViewModel() {

    val name = ObservableField("ㅇㅇㅇㅇ")
    val imageRequest = ImageRequest()
    val schedulers = Schedulers()

    fun onClick(v: View) {
        name.set("크크크크")
    }


    val onQueryTextChange = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            Timber.d("onQueryTextSubmit = newText = $query")
            return false;
        }

        override fun onQueryTextChange(query: String?): Boolean {
            //imageRequest.images(newText!!).subscribeOn()
            var subscribeBy = imageRequest.images(query!!).subscribeOn(schedulers.io()).observeOn(schedulers.ui())
                .subscribeBy(onComplete = {

                }, onError = {

                }, onNext = {

                })
            return false
        }
    }
}