package com.github.youribonnaffe.feign;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMarketPlaceInterfaceMockTest {

    @Test
    void onlyDomesticPetsAreReturned_apiMock() {
        PetMarketPlace marketPlace = new PetMarketPlace(List.of(new PetMarketPlace.PetStoreApi() {
            @Override
            public List<PetMarketPlace.Pet> findByStatus(String status) {
                return List.of(
                        new PetMarketPlace.Pet("Kitty", new PetMarketPlace.Pet.Category("Cats")),
                        new PetMarketPlace.Pet("Rintintin", new PetMarketPlace.Pet.Category("Dogs")),
                        new PetMarketPlace.Pet("Roi", new PetMarketPlace.Pet.Category("Lions"))
                );
            }
        }));

        List<PetMarketPlace.Pet> domesticPets = marketPlace.findDomesticPets();

        assertEquals(2, domesticPets.size());
    }

}