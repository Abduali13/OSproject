package com.company.osproject.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedHouseApi(){
        return GroupedOpenApi.builder()
                .group("House")
                .pathsToMatch("/house/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedAddressApi(){
        return GroupedOpenApi.builder()
                .group("Address")
                .pathsToMatch("/address/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedCustomerApi(){
        return GroupedOpenApi.builder()
                .group("Customer")
                .pathsToMatch("/customer/**")
                .build();
    }


}
