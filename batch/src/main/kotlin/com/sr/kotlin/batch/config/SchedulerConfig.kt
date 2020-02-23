package com.sr.kotlin.batch.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class SchedulerConfig(@Autowired
                      var jobLauncher: JobLauncher, @Autowired
                      var job: Job) {

    @Scheduled(cron = "*/15 * * * * ?")
    @Throws(Exception::class)
    fun starter() {
        val params: JobParameters = JobParametersBuilder()
                .addString("JobID", System.currentTimeMillis().toString())
                .toJobParameters()
        jobLauncher.run(job, params)
    }
}