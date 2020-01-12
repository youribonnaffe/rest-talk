package com.github.youribonnaffe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;

public class RetrofitClient {

    private static final String URL = "http://localhost:8080/api/v3/";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
                .baseUrl(URL)
                .build();

        PetStoreApi service = retrofit.create(PetStoreApi.class);

        Response<List<Pet>> response = service.findByStatus("available").execute();

        Pet pet = response.body().get(0);
        System.out.println(pet.name);
    }

    public interface PetStoreApi {

        @GET("pet/findByStatus")
        Call<List<Pet>> findByStatus(@Query("status") String status);
    }

    static class Pet {
        public String id;
        public String name;
    }
}


