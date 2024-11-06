package de.codecentric.app.service;

import de.codecentric.app.model.Farmer;
import de.codecentric.app.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public List<Farmer> findFarmers() {
        // TODO
        return null;
    }

    public Farmer findFarmerByLastName(String lastName) {
        // TODO
        return null;
    }
}
