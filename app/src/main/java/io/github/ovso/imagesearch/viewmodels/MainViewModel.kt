package io.github.ovso.imagesearch.viewmodels

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val name = ObservableField("ㅇㅇㅇㅇ")
    fun btnClick(v: View) = name.set("ㅋㅋㅋㅋㅋㅋ")

    fun fabClick() {
        name.set("ㅎㅎㅎㅎㅎㅎㅎ")
    }
}