package com.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Authentication {

    private static final String KEY = "a5c14264c267638eef4d4bc13e666b81";
    private static final String TOKEN = "165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63";
    private static final String BASE_URL = "https://api.trello.com";
    private RequestSpecification requestSpecification;


    public Authentication(){
        requestSpecification = new RequestSpecBuilder().setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json").
                addQueryParam("key", KEY ).
                addQueryParam("token", TOKEN).
                build();
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}
