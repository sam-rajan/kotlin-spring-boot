package com.sr.kotlin.batch.reader

import com.sr.kotlin.batch.model.JsonData
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemReader
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
@StepScope
class EmulatedDataReader : ItemReader<JsonData> {

    private val emulatedData: MutableList<JsonData> = mutableListOf()
    private val iterator: Iterator<JsonData>


    init {
        //Emulate a data read
        val fileCount = Random.nextInt(2, 8)
        for (count in 0 until fileCount) {
            val data = JsonData("Value is ${Random.nextInt(1, 1000000000)}", count)
            this.emulatedData.add(data)
        }
        this.iterator = emulatedData.iterator()
    }

    override fun read(): JsonData? {

        while(iterator.hasNext()) {
            return iterator.next()
        }

        return null
    }
}