package com.scaler.myfirstapi.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration // Spring will only create bean of the class in which some Annotations are present.
public class RestTemplateConfig {
    @Bean
    // we create this class to make http call
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
