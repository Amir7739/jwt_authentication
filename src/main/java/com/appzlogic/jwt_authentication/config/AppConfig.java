package com.appzlogic.jwt_authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
    // line 17 to 24 for in memory database
    // @Bean
    // public UserDetailsService userDetailsService() {
    // UserDetails user =
    // User.builder().username("amir").password(passwordEncoder().encode("abc")).roles("ADMIN")
    // .build();
    // UserDetails user1 =
    // User.builder().username("alam").password(passwordEncoder().encode("abc")).roles("ADMIN")
    // .build();
    // return new InMemoryUserDetailsManager(user, user1);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
