package io.github.ovso.imagesearch.service.model

import com.google.gson.annotations.SerializedName

object CustomSearch {

    data class Result(
        val context: Context,
        val items: List<Item>,
        val kind: String,
        val queries: Queries,
        val searchInformation: SearchInformation,
        val url: Url
    )

    data class Queries(
        val request: List<Request>
    )

    data class Request(
        val count: Int,
        val cx: String,
        val inputEncoding: String,
        val outputEncoding: String,
        val safe: String,
        val searchTerms: String,
        val startIndex: Int,
        val title: String,
        val totalResults: String
    )

    data class Context(
        val title: String
    )

    data class Item(
        val cacheId: String,
        val displayLink: String,
        val formattedUrl: String,
        val htmlFormattedUrl: String,
        val htmlSnippet: String,
        val htmlTitle: String,
        val kind: String,
        val link: String,
        val pagemap: Pagemap,
        val snippet: String,
        val title: String
    )

    data class Pagemap(
        val cse_image: List<CseImage>,
        val cse_thumbnail: List<CseThumbnail>
    )

    data class CseThumbnail(
        val height: String,
        val src: String,
        val width: String
    )

    data class CseImage(
        val src: String
    )

    data class Url(
        val template: String,
        val type: String
    )

    data class SearchInformation(
        val formattedSearchTime: String,
        val formattedTotalResults: String,
        val searchTime: Double,
        val totalResults: String
    )
}