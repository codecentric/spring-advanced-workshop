package de.codecentric.app;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@ActiveProfiles("prod")
class FarmEnvironmentServiceTest {

    @Autowired
    private FarmService farmEnvironmentService;

    @Test
    void configurationShouldNotBeNull() {
        assertThat(farmEnvironmentService.getFarmName()).isNotEmpty();
        assertThat(farmEnvironmentService.getFarmLocation()).isNotEmpty();
        assertThat(farmEnvironmentService.getCows()).isNotZero();
        assertThat(farmEnvironmentService.getSheep()).isNotZero();
        assertThat(farmEnvironmentService.getPigs()).isNotZero();
    }

    @Test
    void configurationShouldBeProfileSpecific() {
        assertThat(farmEnvironmentService.getFarmName()).isEqualTo("Prod Farm");
        assertThat(farmEnvironmentService.getFarmLocation()).isEqualTo("Prod Location");
        assertThat(farmEnvironmentService.getCows()).isEqualTo(50);
        assertThat(farmEnvironmentService.getSheep()).isEqualTo(80);
        assertThat(farmEnvironmentService.getPigs()).isEqualTo(60);
    }
}

