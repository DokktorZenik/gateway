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
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/priorities")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/priorities",
                                "/v1/organizations/${orgName}/priorities"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/statuses")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/statuses",
                                "/v1/organizations/${orgName}/statuses"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/estimates")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/estimates",
                                "/v1/organizations/${orgName}/estimates"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/user/{userId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/user/(?<userId>.*)",
                                "/v1/organizations/user/${userId}"))
                        .uri(utils.getMETADATA_DOMEN()))
                .route(r -> r.path("/organizations/{orgName}/projects/user/{userId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/user/(?<userId>.*)",
                                "/v1/organizations/${orgName}/projects/user/${userId}"))
                        .uri(utils.getMETADATA_DOMEN()));
    }

}
