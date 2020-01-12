package com.github.youribonnaffe.feign;

import feign.*;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMarketPlaceHttpClientMockTest {

    @Test
    void onlyDomesticPetsAreReturned_serverMock() {
        Client httpClientMock = (request, options) -> {
            // language=JSON
            String responseBody = "[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 2,\n" +
                    "      \"name\": \"Cats\"\n" +
                    "    },\n" +
                    "    \"name\": \"Cat 1\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 2,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 2,\n" +
                    "      \"name\": \"Cats\"\n" +
                    "    },\n" +
                    "    \"name\": \"Cat 2\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag3\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 4,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 1,\n" +
                    "      \"name\": \"Dogs\"\n" +
                    "    },\n" +
                    "    \"name\": \"Dog 1\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 7,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 4,\n" +
                    "      \"name\": \"Lions\"\n" +
                    "    },\n" +
                    "    \"name\": \"Lion 1\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 8,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 4,\n" +
                    "      \"name\": \"Lions\"\n" +
                    "    },\n" +
                    "    \"name\": \"Lion 2\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag3\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 9,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 4,\n" +
                    "      \"name\": \"Lions\"\n" +
                    "    },\n" +
                    "    \"name\": \"Lion 3\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag4\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 10,\n" +
                    "    \"category\": {\n" +
                    "      \"id\": 3,\n" +
                    "      \"name\": \"Rabbits\"\n" +
                    "    },\n" +
                    "    \"name\": \"Rabbit 1\",\n" +
                    "    \"photoUrls\": [\n" +
                    "      \"url1\",\n" +
                    "      \"url2\"\n" +
                    "    ],\n" +
                    "    \"tags\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"tag3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"tag4\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"status\": \"available\"\n" +
                    "  }\n" +
                    "]";
            return Response.builder()
                    .request(request)
                    .status(200)
                    .body(responseBody, StandardCharsets.UTF_8)
                    .build();
        };

        PetMarketPlace.PetStoreApi petStore = Feign.builder()
                .client(httpClientMock)
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(PetMarketPlace.PetStoreApi.class, "http://localhost:8080/");
        PetMarketPlace marketPlace = new PetMarketPlace(List.of(petStore));

        List<PetMarketPlace.Pet> domesticPets = marketPlace.findDomesticPets();

        assertEquals(3, domesticPets.size());
    }
}