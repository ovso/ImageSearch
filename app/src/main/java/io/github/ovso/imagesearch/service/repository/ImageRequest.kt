package io.github.ovso.imagesearch.service.repository

import io.github.ovso.imagesearch.service.model.Search
import io.reactivex.Observable
import okhttp3.Headers


class ImageRequest : BaseRequest<ImageService>() {

    override val apiClass: Class<ImageService>
        get() = ImageService::class.java

    override val baseUrl: String
        get() = BaseUrl.SEARCH

    override fun createHeaders(): Headers {
        return Headers.Builder().add(Header.NAME, Header.VALUE).build()
    }

    fun images(query: String): Observable<Search> {
        return api.images(BaseRequest.createParam(query))
    }
}