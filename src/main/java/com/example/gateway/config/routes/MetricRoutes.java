package com.example.gateway.config.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class MetricRoutes {

    private static String DOMEN = "http://metric-service";

    public static RouteLocatorBuilder.Builder metricRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tasks/analytics")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tasks",
                                "/organizations/${orgName}/projects/${projectName}/tasks"))
                        .uri(DOMEN));
    }

}
