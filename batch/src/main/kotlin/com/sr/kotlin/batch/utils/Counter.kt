package com.sr.kotlin.batch.utils

object Counter {
    private var count: Int = 0

    fun getNextVal(): Int {
        return count++
    }
}