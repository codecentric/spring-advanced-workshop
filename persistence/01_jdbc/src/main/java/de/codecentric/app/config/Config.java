package de.codecentric.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "de.codecentric.app")
public class Config {

    @Bean
    public DataSource dataSource() {
        // TODO
        return null;
    }

}
