package com.github.youribonnaffe;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class Wiremock {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options()
                .port(8181)
                .withRootDirectory("."));
        wireMockServer.start();
    }

}
