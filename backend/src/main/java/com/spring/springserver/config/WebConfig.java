package com.spring.springserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://westreedserver.kro.kr:3000")
                        .allowedOriginPatterns("*") //
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS" , "PATCH")
                        .allowCredentials(true);
            }
        };
    }
}
