package de.codecentric.app.bonus;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

// Lösung Bonus 1
@SpringBootTest(args = {"--farm.name=CLI Farm", "--farm.location=CLI Location"})
public class ApplicationCommandLineTest {

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
    void configurationShouldBeSetByCommandLine() {
        assertThat(farmConfigService.getFarmName()).isEqualTo("CLI Farm");
        assertThat(farmConfigService.getFarmLocation()).isEqualTo("CLI Location");
        assertThat(farmConfigService.getCows()).isEqualTo(5);
        assertThat(farmConfigService.getSheep()).isEqualTo(10);
        assertThat(farmConfigService.getPigs()).isEqualTo(7);
    }
}
