package com.github.youribonnaffe.feign;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMarketPlaceInterfaceMockTest {

    private static final List<PetMarketPlace.Pet> MOCKED_DATA = List.of(
            new PetMarketPlace.Pet("Kitty", new PetMarketPlace.Pet.Category("Cats")),
            new PetMarketPlace.Pet("Rintintin", new PetMarketPlace.Pet.Category("Dogs")),
            new PetMarketPlace.Pet("Roi", new PetMarketPlace.Pet.Category("Lions"))
    );

    @Test
    void onlyDomesticPetsAreReturned_apiMock() {

        PetMarketPlace petMarketPlace = new PetMarketPlace(List.of(new PetMarketPlace.PetStoreApi() {
            @Override
            public List<PetMarketPlace.Pet> findByStatus(String status) {
                return MOCKED_DATA;
            }
        }));

        List<PetMarketPlace.Pet> pets = petMarketPlace.findDomesticPets();

        assertEquals(2, pets.size());
    }

}