package de.codecentric.app.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
// Lösung Aufgabe 1.2
@ConfigurationProperties(prefix = "farm")
@Getter
@Setter
public class FarmConfig {

    private String name;
    private String location;
    private AnimalConfig animal;
}
