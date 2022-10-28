package com.example.repository.gateway.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestPath = exchange.getRequest().getPath().value();

        if(exchange.getRequest().getPath().equals("/university/student")) {
            System.out.println(String.format("Data from external service %s", requestPath));
        }
        if(exchange.getRequest().getHeaders().containsKey("teacher")) {
            System.out.println(String.format("Data from external service %s,", requestPath));
        }

        return chain.filter(exchange);

    }
















}
