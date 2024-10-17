package com.example.gateway.filter;

import com.example.gateway.security.UserServiceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class GatewayFilter implements WebFilter {

    UserServiceConnector userServiceConnector;

    private static final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        logger.info("Incoming request to internal service: " + exchange.getRequest().getURI());

        String jwt = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (jwt == null || jwt.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            DataBuffer buffer = exchange.getResponse()
                    .bufferFactory()
                    .wrap("Missing Authorization token".getBytes(StandardCharsets.UTF_8));
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
            return exchange.getResponse().writeWith(Mono.just(buffer));
        }

        return userServiceConnector.sendRequest(jwt)
                .flatMap(result -> {
                    if (result) {

                        return chain.filter(exchange);
                    } else {

                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        DataBuffer buffer = exchange.getResponse()
                                .bufferFactory()
                                .wrap("JWT unauthorized".getBytes(StandardCharsets.UTF_8));
                        exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
                        return exchange.getResponse().writeWith(Mono.just(buffer));
                    }
                })
                .onErrorResume(e -> {

                    logger.error("Error occurred while validating JWT: ", e);
                    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    DataBuffer buffer = exchange.getResponse()
                            .bufferFactory()
                            .wrap("Internal server error".getBytes(StandardCharsets.UTF_8));
                    exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
                    return exchange.getResponse().writeWith(Mono.just(buffer));
                });
    }
}