package de.codecentric.app.bonus;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
// Lösung Bonus 2.2
@TestPropertySource(properties = {
        "FARM_NAME=ENV Farm",
        "FARM_LOCATION=ENV Location",
})
class ApplicationEnvironmentVariablesTest {

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

    @Test
    void configurationShouldBeSetByEnvironmentVariables() {
        assertThat(farmConfigService.getFarmName()).isEqualTo("ENV Farm");
        assertThat(farmConfigService.getFarmLocation()).isEqualTo("ENV Location");
        assertThat(farmConfigService.getCows()).isEqualTo(5);
        assertThat(farmConfigService.getSheep()).isEqualTo(10);
        assertThat(farmConfigService.getPigs()).isEqualTo(7);
    }
}

