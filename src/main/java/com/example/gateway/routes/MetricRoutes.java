package com.example.gateway.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class MetricRoutes {

    private static String DOMEN = System.getenv("METRIC_URL");

    public static RouteLocatorBuilder.Builder metricRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/metric")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/metric",
                                "/v1/organizations/${orgName}/projects/${projectName}/metric"))
                        .uri(DOMEN));
    }

}
