package com.website.securitykonfiguracja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->{
            authorizeRequests
                    .requestMatchers("/styles/**").permitAll()
                    .anyRequest().authenticated();
        });
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("superadmin").password("admin").roles("ADMIN").build();
//        UserDetails janPrzystal = userBuilder.username("JanPrzystał").password("zaq1@WSX").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,janPrzystal);
//    }
//
}
