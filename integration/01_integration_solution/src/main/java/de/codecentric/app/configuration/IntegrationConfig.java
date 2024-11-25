package de.codecentric.app.configuration;

import de.codecentric.app.handler.OutputHandler;
import de.codecentric.app.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {

    // Lösung 1.1
    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    // Lösung Bonus.2
    @Bean
    public MessageChannel filteredInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel filteredOutputChannel() {
        return new DirectChannel();
    }

    // Lösung 1.3
    @Bean
    public StandardIntegrationFlow uppercaseFlow(MessageService messageService) {
        return IntegrationFlow.from(inputChannel())
                .handle(messageService, "processMessage")
                .channel(outputChannel())
                .get();
    }

    // Lösung Bonus.2
    @Bean
    public StandardIntegrationFlow filterFlow(MessageService messageService) {
        return IntegrationFlow.from(filteredInputChannel())
                .handle(messageService, "processMessage")
                .filter((String s) -> s.length() > 5)
                .channel(filteredOutputChannel())
                .get();
    }

    // Lösung 1.4
    @Bean
    @ServiceActivator(inputChannel = "outputChannel")
    public MessageHandler loggingHandler() {
        return new OutputHandler();
    }

    // Lösung Bonus.2
    @Bean
    @ServiceActivator(inputChannel = "filteredOutputChannel")
    public MessageHandler filterLoggingHandler() {
        return new OutputHandler();
    }
}
