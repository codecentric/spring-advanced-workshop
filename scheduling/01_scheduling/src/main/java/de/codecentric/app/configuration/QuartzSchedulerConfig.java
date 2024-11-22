package de.codecentric.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzSchedulerConfig {

    @Bean
    public SchedulerFactoryBean scheduler() {
        // TODO
        return null;
    }

}
