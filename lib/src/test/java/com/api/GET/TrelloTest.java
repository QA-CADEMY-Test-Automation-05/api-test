package com.api.GET;

import com.api.Authentication;
import com.api.RequestManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TrelloTest {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public TrelloTest() {
        requestSpecification = new Authentication().getRequestSpecification();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType( "application/json")
                .expectStatusCode(200).build();

    }

    @Test
    public void getBords() {
        given()
                .spec(requestSpecification)
                .get("/1/members/me/boards")
                .then().log().all().spec(responseSpecification);
    }

    @Test
    public void getBordsImproved() {
        Response res = RequestManager.get("/1/members/me/boards");
        res.then().statusCode(200);
    }

    @Test
    public void CreateBoard(){
        given().spec(requestSpecification).
                body("{\"name\" : \"REST ASSURE\"}")
                .post("/1/boards")
                .then()
                .log().all().statusCode(200);
    }
}
