package com.example.gateway.config;

import com.example.gateway.routes.Route;
import com.example.gateway.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.WebFilter;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final List<Route> routeList;

    private final Utils utils;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        return routeList.stream()
                .reduce(routes, (acc, route) -> route.routes(acc), (acc1, acc2) -> acc1)
                .build();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(utils.getUSER_DOMAIN())
                .build();
    }

    @Bean
    public WebFilter corsFilter() {
        return (exchange, chain) -> {
            ServerHttpResponse response = exchange.getResponse();
            ServerHttpRequest request = exchange.getRequest();

            if (CorsUtils.isCorsRequest(request)) {
                HttpHeaders headers = response.getHeaders();
                headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
                headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
                headers.add("Access-Control-Allow-Headers", "*");
                headers.add("Access-Control-Allow-Credentials", "true");

                if (request.getMethod() == HttpMethod.OPTIONS) {
                    exchange.getAttributes().put("CORS_FILTERED", true);
                    response.setStatusCode(HttpStatus.OK);
                    return response.setComplete();
                }
            }
            exchange.getAttributes().put("CORS_FILTERED", true);
            return chain.filter(exchange);
        };
    }

}
