package com.example.gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class MetricRoutes {

    @Value("${external.metric-api}")
    private static String DOMEN;

    public static RouteLocatorBuilder.Builder metricRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/metric")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/metric",
                                "/v1/organizations/${orgName}/projects/${projectName}/metric"))
                        .uri(DOMEN));
    }

}
