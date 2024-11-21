package de.codecentric.app;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
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

    @Test
    void configurationShouldBeProfileSpecific() {
        fail("Not yet implemented");
    }
}

