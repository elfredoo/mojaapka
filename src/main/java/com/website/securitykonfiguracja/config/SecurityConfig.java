package com.website.securitykonfiguracja.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests ->{
            requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/styles/**", "/img/**").permitAll()
                    .requestMatchers("/h2-console/**").permitAll()
                    .requestMatchers("/register","/confirmation").permitAll()
                    .requestMatchers("/secured","/change-password").hasAnyRole("USER","ADMIN")
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .anyRequest().authenticated();
        });
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.logout(logout ->
                logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                        .logoutSuccessUrl("/"));
        http.csrf(csrf ->csrf.ignoringRequestMatchers(PathRequest.toH2Console()));
        http.headers(
                config-> config.frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::sameOrigin
                )
        );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
