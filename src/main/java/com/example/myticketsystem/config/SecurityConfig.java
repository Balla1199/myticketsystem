package com.example.myticketsystem.config;

import com.example.myticketsystem.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF protection is disabled for simplicity; enable as needed
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/users/**").hasRole("ADMIN")
                        .requestMatchers("/api/tickets/create").hasRole("APPRENANT")
                        .requestMatchers("/api/tickets/read").hasAnyRole("APPRENANT", "FORMATEUR")
                        .requestMatchers("/api/base-connaissances/create", "/api/base-connaissances/update/", "/api/base-connaissances/delete").hasRole("FORMATEUR")
                        .requestMatchers("/api/base-connaissances/read").hasAnyRole("FORMATEUR", "APPRENANT")
                        .requestMatchers("/api/responses/create/{ticketId}", "/api/responses/update/{ticketId}", "/api/responses/delete/{ticketId}").hasRole("FORMATEUR")
                        .requestMatchers("/api/responses/read").hasAnyRole("FORMATEUR", "APPRENANT")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
