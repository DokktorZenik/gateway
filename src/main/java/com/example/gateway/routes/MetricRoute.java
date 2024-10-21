package com.example.gateway.routes;

import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MetricRoute implements Route {

    private final Utils utils;

    @Override
    public RouteLocatorBuilder.Builder routes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/metric")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/metric",
                                "/v1/organizations/${orgName}/projects/${projectName}/metric"))
                        .uri(utils.getMETRIC_DOMEN()));
    }

}
