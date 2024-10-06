package com.example.gateway.config.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class MetadataRoutes {

    private static String DOMEN = "http://metadata-service";

    public static RouteLocatorBuilder.Builder metadataRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations")
                        .filters(f -> f.setPath("/organizations"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)",
                                "/organizations/${orgName}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects",
                                "/organizations/${orgName}/projects"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)",
                                "/organizations/${orgName}/projects/${projectName}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags",
                                "/organizations/${orgName}/projects/${projectName}/tags"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags/{tagId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags/(?<tagId>.*)",
                                "/organizations/${orgName}/projects/${projectName}/tags/${tagId}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities",
                                "/organizations/${orgName}/projects/${projectName}/priorities"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities/{priorityId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities/(?<priorityId>.*)",
                                "/organizations/${orgName}/projects/${projectName}/priorities/${priorityId}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields",
                                "/organizations/${orgName}/projects/${projectName}/fields"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields/{fieldTitle}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields/(?<fieldTitle>.*)",
                                "/organizations/${orgName}/projects/${projectName}/fields/${fieldTitle}"))
                        .uri(DOMEN));
    }

}
