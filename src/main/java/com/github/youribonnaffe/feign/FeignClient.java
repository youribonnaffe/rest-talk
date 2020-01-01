package com.github.youribonnaffe.feign;

import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;

import java.util.List;

public class FeignClient {

    private static final String URL = "http://localhost:8080/";

    public static void main(String[] args) {

        PetStoreApi service = feign.Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(PetStoreApi.class, URL);

        List<Pet> pets = service.findByStatus("available");

        System.out.println(pets.get(0).id + " " + pets.get(0).name);
    }

    interface PetStoreApi {
        @RequestLine("GET /api/v3/pet/findByStatus?status={status}")
        List<Pet> findByStatus(@Param("status") String status);
    }

    static class Pet {
        public String id;
        public String name;
    }
}
