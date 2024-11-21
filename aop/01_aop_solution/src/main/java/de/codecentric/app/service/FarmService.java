package de.codecentric.app.service;

import org.springframework.stereotype.Service;

@Service
public class FarmService {

    public void feedAnimals() {
        System.out.println("Feeding animals...");
    }

    public void harvestCrops() throws Exception {
        System.out.println("Harvesting crops...");
        throw new Exception("Crops are already harvested.");
    }

}
