package de.codecentric.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "de.codecentric.app")
public class Config {

    @Bean
    public DataSource dataSource() {
        // TODO
        return null;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // TODO
        return null;
    }

}
