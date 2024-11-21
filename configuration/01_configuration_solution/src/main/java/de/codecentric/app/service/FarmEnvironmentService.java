package de.codecentric.app.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FarmEnvironmentService implements FarmService {

    private final Environment environment;

    public FarmEnvironmentService(Environment environment) {
        this.environment = environment;
    }


    @Override
    public String getFarmName() {
        return environment.getProperty("farm.name");
    }

    @Override
    public String getFarmLocation() {
        return environment.getProperty("farm.location");
    }

    @Override
    public Integer getCows() {
        return environment.getProperty("farm.animal.cows", Integer.class);
    }

    @Override
    public Integer getSheep() {
        return environment.getProperty("farm.animal.sheep", Integer.class);
    }

    @Override
    public Integer getPigs() {
        return environment.getProperty("farm.animal.pigs", Integer.class);
    }
}
