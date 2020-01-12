package com.github.youribonnaffe.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PetTest {

    @Test
    void readValue() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        Pet pet = mapper.readValue("{\n" +
                "  \"birthday\": \"2010-01-18\",\n" +
                "  \"weight\": 10,\n" +
                "  \"category\": \"DOG\"\n" +
                "}\n" +
                "\n", Pet.class);

        assertEquals(Weight.kilograms(10), pet.getWeight());
        assertEquals(Category.DOG, pet.getCategory());
        assertEquals(LocalDate.parse("2010-01-18"), pet.getBirthday());
    }

    @Test
    void readValue_newField() {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        UnrecognizedPropertyException exception = assertThrows(UnrecognizedPropertyException.class, () ->
                mapper.readValue("{\n" +
                        "  \"birthday\": \"2010-01-18\",\n" +
                        "  \"weight\": 10,\n" +
                        "  \"category\": \"DOG\",\n" +
                        "  \"name\": \"Rintintin\"\n" +
                        "}\n" +
                        "\n", Pet.class));

        exception.printStackTrace();
    }


}