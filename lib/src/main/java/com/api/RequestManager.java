package com.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestManager {

    private static RequestSpecification requestSpecification = new Authentication().getRequestSpecification();

    public static Response get(String endpoint){
        return given().spec(requestSpecification)
                .log().all().when().get(endpoint);
    }

    public static Response post(String enpoint, String body){
        return given().spec(requestSpecification)
                .body(body)
                .when()
                .post(enpoint);
    }

    public static Response delete(String endpoint) {
        return given().spec(requestSpecification)
                .when().delete(endpoint);
    }

    public static Response put(String endpoint, String body) {
        return given().spec(requestSpecification)
                .body(body)
                .when()
                .put(endpoint);
    }
}
