package com.github.youribonnaffe.feign;

import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class PetMarketPlace {

    private static final String URL = "http://localhost:8080/";

    private List<PetStoreApi> stores;

    public PetMarketPlace(List<PetStoreApi> stores) {
        this.stores = stores;
    }

    public List<Pet> findDomesticPets() {
        return stores.stream()
                .flatMap(store -> store.findByStatus("available").stream())
                .filter(Pet::isDomestic)
                .collect(Collectors.toList());
    }

    interface PetStoreApi {
        @RequestLine("GET /api/v3/pet/findByStatus?status={status}")
        List<Pet> findByStatus(@Param("status") String status);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Pet {
        private String name;
        private Category category;

        public boolean isDomestic() {
            return category.isDomestic();
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        static class Category {
            private String name;

            public boolean isDomestic() {
                return "Dogs".equals(name) || "Cats".equals(name);
            }
        }
    }

    public static void main(String[] args) {
        PetStoreApi petStore = feign.Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(PetStoreApi.class, URL);

        List<Pet> pets = new PetMarketPlace(List.of(petStore)).findDomesticPets();

        System.out.println(pets);
    }
}
