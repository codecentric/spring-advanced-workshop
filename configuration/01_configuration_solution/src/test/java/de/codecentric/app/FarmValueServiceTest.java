package de.codecentric.app;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
// Lösung 2.3
@ActiveProfiles("dev")
class FarmValueServiceTest {

    @Autowired
    private FarmService farmValueService;

    @Test
    void configurationShouldNotBeNull() {
        assertThat(farmValueService.getFarmName()).isNotEmpty();
        assertThat(farmValueService.getFarmLocation()).isNotEmpty();
        assertThat(farmValueService.getCows()).isNotZero();
        assertThat(farmValueService.getSheep()).isNotZero();
        assertThat(farmValueService.getPigs()).isNotZero();
    }

    // Lösung 2.4
    @Test
    void configurationShouldBeProfileSpecific() {
        assertThat(farmValueService.getFarmName()).isEqualTo("Dev Farm");
        assertThat(farmValueService.getFarmLocation()).isEqualTo("Dev Location");
        assertThat(farmValueService.getCows()).isEqualTo(15);
        assertThat(farmValueService.getSheep()).isEqualTo(20);
        assertThat(farmValueService.getPigs()).isEqualTo(12);
    }
}

