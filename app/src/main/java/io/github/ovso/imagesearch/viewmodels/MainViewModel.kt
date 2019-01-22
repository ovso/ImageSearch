package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel : ViewModel() {
    val name = ObservableField("ㅇㅇㅇㅇ")

    fun onClick(v: View) {
        name.set("크크크크")
    }


    val onQueryTextChange = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            Timber.d("onQueryTextSubmit = newText = $query")
            return false;
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            Timber.d("onQueryTextChange = newText = $newText")
            return false
        }
    }
}