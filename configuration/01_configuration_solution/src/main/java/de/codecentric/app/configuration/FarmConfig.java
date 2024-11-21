package de.codecentric.app.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "farm")
@Getter
@Setter
public class FarmConfig {

    private String name;
    private String location;
    private AnimalConfig animal;
}
