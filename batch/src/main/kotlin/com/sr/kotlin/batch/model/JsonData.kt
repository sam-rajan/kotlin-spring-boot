package com.sr.kotlin.batch.model

import java.time.LocalDateTime

data class JsonData(val key: String, val index: Int) {
    var createdDate: LocalDateTime? = null
}