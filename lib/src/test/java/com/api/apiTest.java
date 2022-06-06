package com.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class apiTest {

    @Test
    public void myFirtsApiTest(){
        given().
                baseUri("https://jsonplaceholder.typicode.com").
                when()
                .log().all()
                .get("/todos").
                then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getBords()
    {
        given()
                .baseUri("https://api.trello.com")
                .param("key", "a5c14264c267638eef4d4bc13e666b81")
                .param("token", "165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63")
                .when()
                .log().all()
                .get("/1/members/me/boards")
                .then().statusCode(200);
    }

    @Test
    public void createBoard()
    {
        given()
//                .param("key", "a5c14264c267638eef4d4bc13e666b81")
//                .param("token", "165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63")
                .header("Content-Type", "application/json")
                .body("{\"name\" : \"RESTTT ASSURE\"}")
                .when()
                .log().all()
                .post("https://api.trello.com/1/boards?key=a5c14264c267638eef4d4bc13e666b81&token=165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63")
                .then()
                .log().all().statusCode(200);
    }
}
