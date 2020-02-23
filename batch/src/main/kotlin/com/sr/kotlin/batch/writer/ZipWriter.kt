package com.sr.kotlin.batch.writer

import com.sr.kotlin.batch.utils.Counter
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File


@Component
@StepScope
class ZipWriter: ItemWriter<String> {

    @Value("\${file.process.location}")
    private lateinit var fileLocation: String

    override fun write(jsonStrings: MutableList<out String>) {
        val fileName = "${fileLocation}File-${Counter.getNextVal()}"
        val file = File("$fileName.json")
        file.writeText(jsonStrings[0])
        file.createNewFile()
    }
}