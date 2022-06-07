package com.api.POST;

import com.api.Authentication;
import com.api.DELETE.TrelloDelete;
import com.api.RequestManager;
import com.api.TrelloObject.Board;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TrelloPost {
    private RequestSpecification requestSpecification;

    private String idBoard;

    public TrelloPost(){
        requestSpecification = new Authentication().getRequestSpecification();
    }

    @After
    public void deleteBoard(){
        given().spec(requestSpecification).log().all().
                delete("/1/boards/" + idBoard)
                .then();
    }

    @Test
    public void CreateBoard(){
        Response res = RequestManager.post("/1/boards", "{\"name\" : \"REST ASSURE\"}");
        idBoard = res.path("id");
        Board board1 = new Board();
        board1.setId(idBoard);
    }

}
