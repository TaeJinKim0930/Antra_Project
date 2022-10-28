package com.example.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@SpringBootApplication
public class gatewayConfig {
        @Bean
        public gatewayConfig gatewayConfig() {
            return new gatewayConfig();
        }
}


