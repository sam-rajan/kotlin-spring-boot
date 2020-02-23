package com.sr.kotlin.batch

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@SpringBootApplication
class ZipgenBatchApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(ZipgenBatchApplication::class.java)
            .web(WebApplicationType.NONE).run(*args)
}
