package com.api.POST;

import com.api.Authentication;
import com.api.DELETE.TrelloDelete;
import com.api.RequestManager;
import com.api.TrelloObject.Board;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
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
        Board board1 = res.as(Board.class);
        idBoard = board1.getId();
        Assert.assertEquals("Name is not equals","REST ASSURE", board1.getName() );
        Assert.assertEquals("Status code is closed",false, board1.isClosed());
        Assert.assertEquals("Status code is open","", board1.getDesc());

    }

    @Test
    public void CreateWithSpecialCharactersInDesc(){
        Response res = RequestManager.post("/1/boards", "{\"name\" : \"REST ASSURE\", \"desc\" : \"Hi im a ***ññ\"}");
        Board board1 = res.as(Board.class);
        idBoard = board1.getId();
        Assert.assertEquals("Name is not equals","REST ASSURE", board1.getName() );
        Assert.assertEquals("Status code is open","Hi im a ***ññ", board1.getDesc());
    }

}
