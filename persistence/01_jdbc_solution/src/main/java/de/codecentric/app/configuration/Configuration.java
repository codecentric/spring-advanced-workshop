package de.codecentric.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "de.codecentric.app")
public class Configuration {

    @Bean
    public DataSource dataSource() {
        // Lösung 1.1
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addDefaultScripts()
                .build();
    }

}
