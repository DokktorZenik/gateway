package com.example.gateway.routes;

import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MetadataRoute implements Route {

    private final Utils utils;

    @Override
    public RouteLocatorBuilder.Builder routes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations")
                        .filters(f -> f.setPath("/v1/organizations"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)",
                                "/v1/organizations/${orgName}"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects",
                                "/v1/organizations/${orgName}/projects"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags",
                                "/v1/organizations/${orgName}/projects/${projectName}/tags"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags/{tagId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags/(?<tagId>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/tags/${tagId}"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities",
                                "/v1/organizations/${orgName}/projects/${projectName}/priorities"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities/{priorityId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities/(?<priorityId>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/priorities/${priorityId}"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields",
                                "/v1/organizations/${orgName}/projects/${projectName}/fields"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields/{fieldTitle}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields/(?<fieldTitle>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/fields/${fieldTitle}"))
                        .uri(utils.getMETADATA_DOMEN()));
    }

}
