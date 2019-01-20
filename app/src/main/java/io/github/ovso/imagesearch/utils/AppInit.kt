package io.github.ovso.imagesearch.utils

import io.github.ovso.imagesearch.BuildConfig
import timber.log.Timber

object AppInit {
    fun timber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}