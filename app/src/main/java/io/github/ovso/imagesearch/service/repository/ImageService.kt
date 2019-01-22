package io.github.ovso.imagesearch.service.repository

import io.github.ovso.imagesearch.service.model.Search
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ImageService {
    @GET("/v2/search/image")
    fun images(@QueryMap queryMap: Map<String, Any>): Observable<Search>
}