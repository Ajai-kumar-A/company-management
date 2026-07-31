package com.mitrahsoft.company_management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://salary-microservice:8081/salary")
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
