package de.codecentric.app.bonus;

import de.codecentric.app.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
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
        fail("Not yet implemented");
    }
}
