package io.github.ovso.imagesearch.service.repository

import io.github.ovso.imagesearch.service.model.CustomSearch
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CustomSearchService {
    @GET("v1")
    fun customSearch(@QueryMap queryMap: Map<String, @JvmSuppressWildcards Any>): Single<CustomSearch.Result>
}