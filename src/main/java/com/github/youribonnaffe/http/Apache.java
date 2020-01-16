package com.github.youribonnaffe.http;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;

public class Apache {

    private static final String URL = "http://localhost:8080/api/v3/pet/findByStatus?status=available";

    public static void main(String[] args) throws IOException {

        Response response = Request.Get(URL)
                .execute();

        System.out.println(response.returnContent().asString());
    }
}
