package com.example.gateway.config.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class CDPRoutes {

    private static String DOMEN = "http://cdp-service";

    public static RouteLocatorBuilder.Builder cdpRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tasks")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tasks",
                                "/organizations/${orgName}/projects/${projectName}/tasks"))
                        .uri(DOMEN));
    }

}
