package com.objeto.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigTest implements WebMvcConfigurer {


    @Value("${spring.custom.allowed-origin}")
    private String allowedOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://ec2-15-164-64-63.ap-northeast-2.compute.amazonaws.com", "http://13.124.25.59")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Add a resource handler for serving static resources from a directory
        registry.addResourceHandler("/docs/**")
                .addResourceLocations("classpath:/static/docs/"); // Replace with the actual location of your static resources
    }
}
