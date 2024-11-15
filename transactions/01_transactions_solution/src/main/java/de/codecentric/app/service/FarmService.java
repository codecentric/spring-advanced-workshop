package de.codecentric.app.service;

import de.codecentric.app.exception.ProductNotAvailableException;
import de.codecentric.app.model.Farm;
import de.codecentric.app.model.Product;
import de.codecentric.app.repository.FarmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmService {

    private final FarmRepository farmRepository;


    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Transactional
    public void transferProducts(Long fromFarmId, Long toFarmId, Long productId, int quantity) {
        Farm fromFarm = farmRepository.findById(fromFarmId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid from farm ID: " + fromFarmId));
        Farm toFarm = farmRepository.findById(toFarmId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid to farm ID: " + toFarmId));

        Product fromProduct = fromFarm.getProducts().stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst().orElseThrow(() -> new ProductNotAvailableException("Product with ID " + productId + " not available in farm: " + fromFarmId));

        if (fromProduct.getQuantity() < quantity) {
            throw new ProductNotAvailableException("Not enough quantity in farm: " + fromFarmId);
        }

        fromProduct.setQuantity(fromProduct.getQuantity() - quantity);

        toFarm.getProducts().stream().filter(product -> product.getId().equals(productId))
                .findFirst().ifPresentOrElse(product -> product.setQuantity(product.getQuantity() + quantity), () -> {
                    Product product = new Product();
                    product.setName(fromProduct.getName());
                    product.setQuantity(quantity);
                    toFarm.getProducts().add(product);
                });
        farmRepository.save(fromFarm);
        farmRepository.save(toFarm);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transferProductsWithException(Long fromFarmId, Long toFarmId, Long productId, int quantity) {
        transferProducts(fromFarmId, toFarmId, productId, quantity);
        throw new RuntimeException("Simulierte Ausnahme");
    }
}
