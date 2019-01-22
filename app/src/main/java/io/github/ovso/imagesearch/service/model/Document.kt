package io.github.ovso.imagesearch.service.model

import java.util.Date

class Document : Comparable<Document> {
    private val thumbnail_url: String? = null
    private val thumbnail: String? = null
    private val datetime: Date? = null
    private val bucket: Boolean = false

    override fun compareTo(o: Document): Int {
        return o.datetime!!.compareTo(this.datetime)
    }

    override fun equals(obj: Any?): Boolean {
        return if (obj is Document) {
            datetime!!.time == obj.datetime!!.time
        } else {
            false
        }
    }
}