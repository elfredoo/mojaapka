package com.website.securitykonfiguracja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->{
            authorizeRequests.requestMatchers("/styles/**").permitAll()
                    .anyRequest().authenticated();
        });
        http.formLogin(login -> login
                .loginPage("/logowanie")
                .usernameParameter("user")
                .passwordParameter("pass")
                .permitAll());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
