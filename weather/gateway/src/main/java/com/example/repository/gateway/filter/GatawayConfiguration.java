package com.example.repository.gateway.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class GatawayConfiguration {

    @Bean
    RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                // request
                .route(predicateSpec -> predicateSpec.path("/university")
                        // route link
                .uri("http://localhost:5432/university"))

                .route(predicateSpec -> predicateSpec.header("student")
                        // link for student
                        .uri("http://localhost:5432/university/student"))

        .route(predicateSpec -> predicateSpec.header("teacher")
                // link for teacher
                .uri("http://localhost:5432/university/teacher"))
                .build();
    }
}

// jdbc:postgresql://localhost:5432/university
//    @RequestMapping(
//            value = "/id",
//            method = RequestMethod.GET,
//            consumes = MediaType.ALL_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )