package de.codecentric.app;

import de.codecentric.app.controller.FarmerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private FarmerController farmerController;


    @Test
    void contextLoads() {
    }

    // Lösung Bonus 4
    @Test
    @WithMockUser(username = "user")
    public void givenAdminUser_whenCallStatus_thenReturnTemplate() {
        String templateName = farmerController.status();
        assertThat(templateName).isEqualTo("status");

    }

    @Test
    @WithAnonymousUser
    public void givenAnonymousUser_whenCallEditFarmer_thenAuthorizationDenied() {
        assertThrows(AuthorizationDeniedException.class, () -> farmerController.status());

    }

}
