package de.codecentric.app;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FarmConfigServiceTest {

    @Autowired
    private FarmService farmConfigService;

    @Test
    void configurationShouldNotBeNull() {
        assertThat(farmConfigService.getFarmName()).isNotNull();
        assertThat(farmConfigService.getFarmLocation()).isNotNull();
        assertThat(farmConfigService.getCows()).isNotNull();
        assertThat(farmConfigService.getSheep()).isNotNull();
        assertThat(farmConfigService.getPigs()).isNotNull();
    }

    // Lösung 1.3
    @Test
    void configurationShouldBeDefault() {
        assertThat(farmConfigService.getFarmName()).isEqualTo("Standard Farm");
        assertThat(farmConfigService.getFarmLocation()).isEqualTo("Default Location");
        assertThat(farmConfigService.getCows()).isEqualTo(5);
        assertThat(farmConfigService.getSheep()).isEqualTo(10);
        assertThat(farmConfigService.getPigs()).isEqualTo(7);
    }
}

