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
                        .requestMatchers("/", "/css/*").permitAll()
                        //.requestMatchers("/addAufgabe").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                //.formLogin(Customizer.withDefaults())

                //.oauth2Login(Customizer.withDefaults());
                .oauth2Login(config-> config.userInfoEndpoint(info->
                        info.userService(new WebService())));
        return httpSecurity.build();
    }


}
