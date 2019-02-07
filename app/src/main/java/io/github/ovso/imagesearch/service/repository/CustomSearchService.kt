package io.github.ovso.imagesearch.service.repository

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CustomSearchService {
    @GET("v1")
    fun customSearch(@QueryMap queryMap: Map<String, @JvmSuppressWildcards Any>): Single<Any>
}