package de.codecentric.app.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class, OutputCaptureExtension.class})
@SpringBootTest
class FarmServiceTest {

    @Autowired
    private FarmService farmService;

    @Test
    public void testFeedAnimals(CapturedOutput output) {
        farmService.feedAnimals();
        assertThat(output).contains("Method called: feedAnimals");
        assertThat(output).contains("Method finished: feedAnimals");
        assertThat(output).contains("void de.codecentric.app.service.FarmService.feedAnimals() executed in:");
    }

    @Disabled(value = "Für Bonusaufgabe diese Zeile auskommentieren/löschen.")
    @Test
    public void testHarvestCrops(CapturedOutput output) {
        try {
            farmService.harvestCrops();
        } catch (Exception e) {
            assertThat(output).contains("harvestCrops");
            assertThat(output).contains("Crops are already harvested.");
        }
    }
}