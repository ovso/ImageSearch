package io.github.ovso.imagesearch.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class Schedulers {

    /**
     * IO thread pool scheduler
     */
    fun io(): Scheduler {
        return io.reactivex.schedulers.Schedulers.io()
    }

    /**
     * Computation thread pool scheduler
     */
    fun computation(): Scheduler {
        return io.reactivex.schedulers.Schedulers.computation()
    }

    /**
     * Main Thread scheduler
     */
    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}