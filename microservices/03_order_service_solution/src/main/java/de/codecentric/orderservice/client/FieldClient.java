package de.codecentric.orderservice.client;

import de.codecentric.orderservice.configuration.FeignConfig;
import de.codecentric.orderservice.model.Field;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "field-service", configuration = FeignConfig.class)
public interface FieldClient {

    @GetMapping("/fields/{id}")
    Field getField(@PathVariable("id") Long id);
}
