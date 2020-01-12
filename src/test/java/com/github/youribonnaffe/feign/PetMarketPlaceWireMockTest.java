package com.github.youribonnaffe.feign;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMarketPlaceWireMockTest {

    private static final String URL = "http://localhost:8080/";

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options()
                .port(0)
                .withRootDirectory("."));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void onlyDomesticPetsAreReturned_serverMock() {
        PetMarketPlace.PetStoreApi petStore = feign.Feign.builder()
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(PetMarketPlace.PetStoreApi.class, wireMockServer.baseUrl());
        PetMarketPlace marketPlace = new PetMarketPlace(List.of(petStore));

        List<PetMarketPlace.Pet> domesticPets = marketPlace.findDomesticPets();

        assertEquals(3, domesticPets.size());
    }
}