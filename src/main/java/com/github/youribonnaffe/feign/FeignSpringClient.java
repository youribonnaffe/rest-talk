package com.github.youribonnaffe.feign;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class FeignSpringClient {

    private static final String URL = "http://localhost:8080/api/v3";

    public static void main(String[] args) {

        PetStoreApi petStore = Feign.builder()
                .decoder(new ResponseEntityDecoder(new JacksonDecoder()))
                .contract(new SpringMvcContract())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(PetStoreApi.class, URL);

        ResponseEntity<List<Pet>> response = petStore.findByStatus("available");

        System.out.println(response.getStatusCode());

        List<Pet> pets = response.getBody();
        System.out.println(pets.get(0).id + " " + pets.get(0).name);
    }

    interface PetStoreApi {
        @GetMapping("/pet/findByStatus?status={status}")
        ResponseEntity<List<Pet>> findByStatus(@RequestParam("status") String status);
    }

    static class Pet {
        public String id;
        public String name;
    }
}
