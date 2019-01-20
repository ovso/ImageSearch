package io.github.ovso.imagesearch

import android.app.Application
import io.github.ovso.imagesearch.utils.AppInit

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppInit.timber();
    }
}