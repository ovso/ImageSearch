package io.github.ovso.imagesearch.service.repository

import com.google.gson.JsonElement
import io.reactivex.Single
import okhttp3.Headers


class NaverSearchRequest : BaseRequest<NaverSearchService>() {

    override val apiClass: Class<NaverSearchService>
        get() = NaverSearchService::class.java

    override val baseUrl: String
        get() = BaseUrl.CUSTOM_SEARCH

    override fun createHeaders(): Headers {
        return Headers.Builder().build()
    }

    fun customSearch(query: String): Single<JsonElement> {
        val param = HashMap<String, Any>()
        param.put("q", query)
        return api.customSearch(param)
    }
}