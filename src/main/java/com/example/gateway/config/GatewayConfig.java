package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.gateway.routes.CDPRoutes.cdpRoutes;
import static com.example.gateway.routes.MetadataRoutes.metadataRoutes;
import static com.example.gateway.routes.MetricRoutes.metricRoutes;


@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes = metricRoutes(routes);
        routes = metadataRoutes(routes);
        routes = cdpRoutes(routes);

        return routes.build();
    }
}
