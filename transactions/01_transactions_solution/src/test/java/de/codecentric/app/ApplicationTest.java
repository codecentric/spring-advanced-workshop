package de.codecentric.app;

import de.codecentric.app.exception.ProductNotAvailableException;
import de.codecentric.app.model.Farm;
import de.codecentric.app.model.Farmer;
import de.codecentric.app.model.Product;
import de.codecentric.app.repository.FarmRepository;
import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private FarmService farmService;
    @Autowired
    private FarmRepository farmRepository;

    Farm farm1;
    Farm farm2;
    Product product1;

    @BeforeEach
    public void setup() {
        farm1 = new Farm();
        Farmer farmer1 = new Farmer();
        farmer1.setFirstName("Anton");
        farmer1.setLastName("Alfred");
        farm1.setFarmer(farmer1);

        product1 = new Product();
        product1.setName("Äpfel");
        product1.setQuantity(100);
        farm1.getProducts().add(product1);

        farm2 = new Farm();
        Farmer farmer2 = new Farmer();
        farmer2.setFirstName("Benjamin");
        farmer2.setLastName("Bauer");
        farm2.setFarmer(farmer2);

        farmRepository.save(farm1);
        farmRepository.save(farm2);
    }

    @Test
    @Transactional
    public void testTransferProducts_successfulTransfer() {
        farmService.transferProducts(farm1.getId(), farm2.getId(), product1.getId(), 50);

        Farm updatedFarm1 = farmRepository.findById(farm1.getId()).orElseThrow();
        Farm updatedFarm2 = farmRepository.findById(farm2.getId()).orElseThrow();

        Product updatedProduct1 = updatedFarm1.getProducts().iterator().next();
        Product updatedProduct2 = updatedFarm2.getProducts().iterator().next();

        assertThat(updatedProduct1.getName()).isEqualTo(updatedProduct2.getName());
        assertThat(updatedProduct1.getQuantity()).isEqualTo(50);
        assertThat(updatedProduct2.getQuantity()).isEqualTo(50);
    }

    @Test
    @Transactional
    public void testTransferProducts_insufficientQuantity() {
        assertThatThrownBy(() -> farmService.transferProducts(farm1.getId(), farm2.getId(), product1.getId(), 150))
                .isInstanceOf(ProductNotAvailableException.class);

        Farm updatedFarm1 = farmRepository.findById(farm1.getId()).orElseThrow();
        assertThat(updatedFarm1.getProducts().iterator().next().getQuantity()).isEqualTo(100);
    }

    @Test
    @Transactional
    public void testTransferProducts_invalidFarmId() {
        assertThatThrownBy(() -> farmService.transferProducts(999L, farm2.getId(), product1.getId(), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Transactional
    public void testTransferProducts_withException() {
        assertThatThrownBy(() -> farmService.transferProductsWithException(farm1.getId(), farm2.getId(), product1.getId(), 50))
                .isInstanceOf(RuntimeException.class);

        Farm updatedFarm1 = farmRepository.findById(farm1.getId()).orElseThrow();
        Farm updatedFarm2 = farmRepository.findById(farm2.getId()).orElseThrow();

        Product updatedProduct1 = updatedFarm1.getProducts().iterator().next();

        assertThat(updatedProduct1.getQuantity()).isEqualTo(100);
        assertThat(updatedFarm2.getProducts()).isEmpty();
    }

}
