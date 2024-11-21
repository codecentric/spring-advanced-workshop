package de.codecentric.app.service;

import de.codecentric.app.configuration.FarmConfig;
import org.springframework.stereotype.Service;

@Service
public class FarmConfigService implements FarmService {

    private final FarmConfig farmConfig;

    public FarmConfigService(FarmConfig farmConfig) {
        this.farmConfig = farmConfig;
    }

    public String getFarmName() {
        return farmConfig.getName();
    }

    public String getFarmLocation() {
        return farmConfig.getLocation();
    }

    public Integer getCows() {
        return farmConfig.getAnimal().getCows();
    }

    public Integer getSheep() {
        return farmConfig.getAnimal().getSheep();
    }

    public Integer getPigs() {
        return farmConfig.getAnimal().getPigs();
    }
}
