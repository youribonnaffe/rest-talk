package com.github.youribonnaffe.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Java8 {

    private static final String URL = "http://localhost:8080/api/v3/pet/findByStatus?status=available";

    public static void main(String[] args) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();

        System.out.println(connection.getResponseCode());
        System.out.println(convertStreamToString(connection.getInputStream()));
    }

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
