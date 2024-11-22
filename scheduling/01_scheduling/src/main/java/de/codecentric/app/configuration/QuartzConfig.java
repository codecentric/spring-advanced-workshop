package de.codecentric.app.configuration;

import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail feedAnimalsJobDetail() {
        // TODO
        return null;
    }

}
