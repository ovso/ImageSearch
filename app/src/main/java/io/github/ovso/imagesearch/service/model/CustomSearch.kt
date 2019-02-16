package io.github.ovso.imagesearch.service.model

object CustomSearch {

  data class Result(
    val items: List<Item>,
    val queries: Queries
  )

  data class Queries(
    val request: List<Request>,
    val nextPage: List<NextPage>

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

  data class NextPage(
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

  data class Item(
    val pagemap: Pagemap
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
}