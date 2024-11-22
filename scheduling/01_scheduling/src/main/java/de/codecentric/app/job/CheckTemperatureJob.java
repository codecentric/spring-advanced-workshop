package de.codecentric.app.job;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckTemperatureJob {

    private double getFarmTemperature() {
        return 10 + (Math.random() * 20);
    }
}
