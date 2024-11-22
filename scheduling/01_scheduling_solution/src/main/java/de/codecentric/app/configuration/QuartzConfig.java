package de.codecentric.app.configuration;

import de.codecentric.app.job.CheckTemperatureJob;
import de.codecentric.app.job.FeedAnimalsJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    // Lösung 1.1
    @Bean
    public JobDetail feedAnimalsJobDetail() {
        return JobBuilder.newJob(FeedAnimalsJob.class)
                .withIdentity("feedAnimalsJob", "farmGroup")
                .storeDurably()
                .build();
    }

    // Lösung Bonus.2
    @Bean
    public JobDetail checkTemperatureJobDetail() {
        return JobBuilder.newJob(CheckTemperatureJob.class)
                .withIdentity("checkTemperatureJob", "farmGroup")
                .storeDurably()
                .build();
    }

}
