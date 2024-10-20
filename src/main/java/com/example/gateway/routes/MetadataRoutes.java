package com.example.gateway.routes;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class MetadataRoutes {

    private static String DOMEN = System.getenv("METADATA_URL");

    public static RouteLocatorBuilder.Builder metadataRoutes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/organizations")
                        .filters(f -> f.setPath("/v1/organizations"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)",
                                "/v1/organizations/${orgName}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects",
                                "/v1/organizations/${orgName}/projects"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags",
                                "/v1/organizations/${orgName}/projects/${projectName}/tags"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/tags/{tagId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/tags/(?<tagId>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/tags/${tagId}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities",
                                "/v1/organizations/${orgName}/projects/${projectName}/priorities"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/priorities/{priorityId}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/priorities/(?<priorityId>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/priorities/${priorityId}"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields",
                                "/v1/organizations/${orgName}/projects/${projectName}/fields"))
                        .uri(DOMEN))
                .route(r -> r.path("/organizations/{orgName}/projects/{projectName}/fields/{fieldTitle}")
                        .filters(f -> f.rewritePath(
                                "/organizations/(?<orgName>.*)/projects/(?<projectName>.*)/fields/(?<fieldTitle>.*)",
                                "/v1/organizations/${orgName}/projects/${projectName}/fields/${fieldTitle}"))
                        .uri(DOMEN));
    }

}
