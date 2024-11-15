package de.codecentric.app.service;

import de.codecentric.app.repository.FarmRepository;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    private final FarmRepository farmRepository;


    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    // TODO
    public void transferProducts(Long fromFarmId, Long toFarmId, Long productId, int quantity) {
        // TODO
    }

    // TODO
    public void transferProductsWithException(Long fromFarmId, Long toFarmId, Long productId, int quantity) {
        // TODO
    }
}
