package de.codecentric.app.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;

@Slf4j
public class CheckTemperatureJob implements Job {

    // Lösung Bonus.1
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        double farmTemperature = getFarmTemperature();
        log.info("Checking temperature at: {} - Current temperature: {} °C", LocalDateTime.now(), farmTemperature);
    }

    private double getFarmTemperature() {
        return 10 + (Math.random() * 20);
    }
}
