package com.sr.kotlin.batch.processor

import com.google.gson.Gson
import com.sr.kotlin.batch.model.JsonData
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
@StepScope
class DataProcessor: ItemProcessor<JsonData, String> {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(DataProcessor::class.java)
    }

    override fun process(jsonData: JsonData): String? {
        LOGGER.info("Processing Data With Key ${jsonData.key}")
        jsonData.createdDate = LocalDateTime.now()
        return Gson().toJson(jsonData)
    }
}