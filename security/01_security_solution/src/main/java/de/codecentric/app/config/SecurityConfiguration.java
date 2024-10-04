package de.codecentric.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Lösung 1.3
                        .requestMatchers("/", "/index", "/login", "/css/**", "/images/**", "/login-error").permitAll()
                        // Lösung 1.4
                        .requestMatchers("/farmer/edit").hasRole("ADMIN")
                        .anyRequest().hasRole("USER")
                )
                // Lösung Bonusaufgabe 1
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successForwardUrl("/farmer/index")
                        .failureUrl("/login-error")
                )
                // Lösung Bonusaufgabe 2
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    // Lösung 1.2
    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        UserDetails user = userBuilder
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = userBuilder
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
