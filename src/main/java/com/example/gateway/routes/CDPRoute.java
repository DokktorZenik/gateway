package com.example.gateway.routes;

import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CDPRoute implements Route {

    private final Utils utils;

    @Override
    public RouteLocatorBuilder.Builder routes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tasks")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tasks",
                                "/v1/organizations/${orgName}/projects/${projectName}/tasks"))
                        .uri(utils.getCDP_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tasks/{taskId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tasks/(?<taskId>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/tasks/${taskId}"))
                        .uri(utils.getCDP_DOMEN()));
    }

}
