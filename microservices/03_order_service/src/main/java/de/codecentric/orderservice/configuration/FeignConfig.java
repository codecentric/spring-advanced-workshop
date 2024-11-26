package de.codecentric.orderservice.configuration;

import de.codecentric.orderservice.client.FieldClientErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FieldClientErrorDecoder();
    }
}
