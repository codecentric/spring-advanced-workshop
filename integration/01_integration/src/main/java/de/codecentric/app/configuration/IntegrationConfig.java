package de.codecentric.app.configuration;

import de.codecentric.app.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {

    // TODO

    @Bean
    public StandardIntegrationFlow uppercaseFlow(MessageService messageService) {
        // TODO
        return IntegrationFlow.from("inputChannel")
                .handle(messageService, "processMessage")
                .channel("outputChannel")
                .get();
    }

    // TODO
    @Bean
    public MessageHandler loggingHandler() {
        return null;
    }

}
