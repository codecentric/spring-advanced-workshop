package de.codecentric.app.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Lösung Bonus.3
@Configuration
public class CheckTemperatureTrigger {

    @Bean
    public Trigger checkTemperatureCronTrigger(JobDetail checkTemperatureJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(checkTemperatureJobDetail)
                .withIdentity("checkTemperatureTrigger", "farmGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .build();
    }
}
