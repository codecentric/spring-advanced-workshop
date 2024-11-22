package de.codecentric.app.trigger;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class FeedAnimalsTrigger {

    // Lösung 1.2
    @Bean
    public Trigger feedAnimalsSimpleTrigger(JobDetail feedAnimalsJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(feedAnimalsJobDetail)
                .withIdentity("feedAnimalsTrigger", "farmGroup")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(3))
                .build();
    }
}
