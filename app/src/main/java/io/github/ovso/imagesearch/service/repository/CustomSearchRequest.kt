package io.github.ovso.imagesearch.service.repository

import io.reactivex.Single
import okhttp3.Headers


class CustomSearchRequest : BaseRequest<CustomSearchService>() {

    override val apiClass: Class<CustomSearchService>
        get() = CustomSearchService::class.java

    override val baseUrl: String
        get() = BaseUrl.CUSTOM_SEARCH

    override fun createHeaders(): Headers {
        return Headers.Builder().build()
    }

    fun customSearch(query: String): Single<Any> {
        val param = HashMap<String, Any>()
        param.put("key", "AIzaSyBUL4F_nU_I6FO-8TfZsetedHIDyLJ-9hM")
        param.put("cx", "012722901045059265659:m8q8x8ftuii")
        param.put("q", query)
        return api.customSearch(param)
    }
}