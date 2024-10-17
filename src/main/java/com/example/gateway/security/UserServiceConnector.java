package com.example.gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserServiceConnector {

    private final WebClient webClient;

    public Mono<Boolean> sendRequest(String jwt) {
        return webClient.post()
                .uri("/api/endpoint")
                .header("Authorization", "Bearer " + jwt)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}
