package com.example.gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class CDPRoutes {

    @Value("${external.cdp-api}")
    private static String DOMEN;

    public static RouteLocatorBuilder.Builder cdpRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tasks")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tasks",
                                "/v1/organizations/${orgName}/projects/${projectName}/tasks"))
                        .uri(DOMEN));
    }

}
