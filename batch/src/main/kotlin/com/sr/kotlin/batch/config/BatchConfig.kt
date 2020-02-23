package com.sr.kotlin.batch.config

import com.sr.kotlin.batch.model.JsonData
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File


@EnableBatchProcessing
@Configuration
class BatchConfig(@Autowired
                  private val jobBuilders: JobBuilderFactory,
                  @Autowired
                  private val stepBuilders: StepBuilderFactory) {

    @Bean
    fun fileGenJob(step: Step): Job? {
        return this.jobBuilders.get("fileGenJob")
                .start(step)
                .build()
    }

    @Bean
    fun step(itemReader: ItemReader<JsonData>,
             itemProcessor: ItemProcessor<JsonData, String>,
             itemWriter: ItemWriter<String>): Step {
        return this.stepBuilders.get("step").chunk<JsonData, String>(2)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build()
    }
}