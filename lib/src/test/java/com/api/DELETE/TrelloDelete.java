package com.api.DELETE;

import com.api.Authentication;
import com.api.RequestManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TrelloDelete {
    private RequestSpecification requestSpecification;

    private String id;

    public TrelloDelete() {
        requestSpecification = new Authentication().getRequestSpecification();
    }

    @Before
    public void CreateBoard(){
        id = given().spec(requestSpecification).
                body("{\"name\" : \"REST ASSURE\"}")
                .post("/1/boards")
                .then().extract().path("id");
    }

    @Test
    public void deleteBoard(){
        Response res = RequestManager.delete("/1/boards/" + id);
        res.then().statusCode(200);
    }
}
