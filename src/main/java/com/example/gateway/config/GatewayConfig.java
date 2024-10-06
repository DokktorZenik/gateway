package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.gateway.config.routes.CDPRoutes.cdpRoutes;
import static com.example.gateway.config.routes.MetadataRoutes.metadataRoutes;
import static com.example.gateway.config.routes.MetricRoutes.metricRoutes;


@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        metricRoutes(routes);
        metadataRoutes(routes);
        cdpRoutes(routes);

        return builder.routes().build();
    }
}
