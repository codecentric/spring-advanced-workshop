package de.codecentric.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FarmValueService implements FarmService {

    // Lösung 2.1
    @Value("${farm.name}")
    private String name;

    @Value("${farm.location}")
    private String location;

    @Value("${farm.animal.cows}")
    private int cows;

    @Value("${farm.animal.sheep}")
    private int sheep;

    @Value("${farm.animal.pigs}")
    private int pigs;

    @Override
    public String getFarmName() {
        return name;
    }

    @Override
    public String getFarmLocation() {
        return location;
    }

    @Override
    public Integer getCows() {
        return cows;
    }

    @Override
    public Integer getSheep() {
        return sheep;
    }

    @Override
    public Integer getPigs() {
        return pigs;
    }
}
