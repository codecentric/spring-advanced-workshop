package de.codecentric.app.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;

@Slf4j
public class FeedAnimalsJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Feeding animals at: {}", LocalDateTime.now());
    }
}
