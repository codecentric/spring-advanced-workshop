package de.codecentric.app.service;

import org.springframework.stereotype.Service;

@Service
public class FarmValueService implements FarmService {


    @Override
    public String getFarmName() {
        return "";
    }

    @Override
    public String getFarmLocation() {
        return "";
    }

    @Override
    public Integer getCows() {
        return 0;
    }

    @Override
    public Integer getSheep() {
        return 0;
    }

    @Override
    public Integer getPigs() {
        return 0;
    }
}
