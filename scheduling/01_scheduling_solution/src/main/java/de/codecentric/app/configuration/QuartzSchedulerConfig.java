package de.codecentric.app.configuration;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzSchedulerConfig {

    // Lösung 1.3 & Bonus.4
    @Bean
    public SchedulerFactoryBean scheduler(JobDetail checkTemperatureJobDetail, Trigger checkTemperatureCronTrigger, JobDetail feedAnimalsJobDetail, Trigger feedAnimalsSimpleTrigger) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(feedAnimalsSimpleTrigger, checkTemperatureCronTrigger);
        factory.setJobDetails(feedAnimalsJobDetail, checkTemperatureJobDetail);
        return factory;
    }

}
