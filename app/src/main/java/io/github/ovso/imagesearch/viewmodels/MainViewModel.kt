package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val name = ObservableField("ㅇㅇㅇㅇ")
    fun onClick(v: View) {
        name.set("크크크크")
    }

}