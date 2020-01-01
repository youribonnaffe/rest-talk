package com.github.youribonnaffe.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringRestTemplate {

    private static final String URL = "http://localhost:8080/api/v3/pet/findByStatus?status=available";

    public static void main(String[] args) {

        ResponseEntity<Pet[]> response = new RestTemplate()
                .getForEntity(URL, Pet[].class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody()[0].name);
    }

    static class Pet {
        public String id;
        public String name;
    }
}
