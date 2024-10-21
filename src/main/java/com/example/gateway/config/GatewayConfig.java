package com.example.gateway.config;

import com.example.gateway.routes.Route;
import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final List<Route> routeList;

    private final Utils utils;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        return routeList.stream()
                .reduce(routes, (acc, route) -> route.routes(acc), (acc1, acc2) -> acc1)
                .build();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(utils.getUSER_API())
                .build();
    }
}
