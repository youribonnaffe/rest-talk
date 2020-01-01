package com.github.youribonnaffe.spring;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SpringWebClient {

    private static final String URL = "http://localhost:8080/api/v3/pet/findByStatus?status=available";

    public static void main(String[] args) {

        WebClient.RequestHeadersUriSpec<?> request = WebClient.create(URL).get();
        ClientResponse response = request.exchange().block();

        Mono<Pet[]> body = response.bodyToMono(Pet[].class);

        System.out.println(response.statusCode());
        System.out.println(body.block()[0].name);
    }

    static class Pet {
        public String id;
        public String name;
    }
}
