package com.example.exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers("/home", "/showTest", "/css/*").permitAll()
                        // .requestMatchers("/addAufgabe").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .oauth2Login(config -> config.userInfoEndpoint(info -> info.userService(new WebService())))
                .formLogin(org.springframework.security.config.Customizer.withDefaults()); // Enable form login for
                                                                                           // local dev
        return httpSecurity.build();
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        org.springframework.security.core.userdetails.UserDetails user = org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(user);
    }

}
