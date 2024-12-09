package com.example.gateway.routes;

import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceRoute implements Route {

    private final Utils utils;

    @Override
    public RouteLocatorBuilder.Builder routes(RouteLocatorBuilder.Builder routes) {
        return routes
                .route(r -> r.path("/auth/register").filters(
                        f -> f.setPath("/v1/auth/register")
                        )
                        .uri(utils.getUSER_DOMAIN()))
                .route(r -> r.path("/auth/login").filters(
                                f -> f.setPath("/v1/auth/login")
                        )
                        .uri(utils.getUSER_DOMAIN()))
                .route(r -> r.path("/auth/validate").filters(
                                f -> f.setPath("/v1/auth/validate")
                        )
                        .uri(utils.getUSER_DOMAIN()));
    }

}


