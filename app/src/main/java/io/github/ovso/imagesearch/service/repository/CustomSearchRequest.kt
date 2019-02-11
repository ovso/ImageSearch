package io.github.ovso.imagesearch.service.repository

import com.google.gson.JsonElement
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

    fun customSearch(query: String): Single<JsonElement> {
        val param = HashMap<String, Any>()
        param.put("key", "AIzaSyAM9aaztXVlGNX40ZoFV5MYvpmg65qOCbQ")
        param.put("cx", "012722901045059265659:m8q8x8ftuii")
        param.put("q", query)
        return api.customSearch(param)
    }
}