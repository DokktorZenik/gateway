package com.example.gateway.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public interface Route {
    RouteLocatorBuilder.Builder routes(RouteLocatorBuilder.Builder routes);
}
