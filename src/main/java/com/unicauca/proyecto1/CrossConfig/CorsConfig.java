package com.unicauca.proyecto1.CrossConfig;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Allow any origin
        config.addAllowedHeader("*"); // Allow any header
        config.addAllowedMethod("*"); // Allow any HTTP method
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}