package com.api.cucumber;

import com.api.RequestManager;
import com.api.TrelloObject.Board;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

public class Hook {

    private Helper helper;
    private Saludo saludo;

    public Hook(Helper helper, Saludo saludo){
        this.helper = helper;
        this.saludo = saludo;
    }

    @After(value = "@BoToBeDelete")
    public void deleteBoard(){
        RequestManager.delete("/1/boards/"+helper.response.getId());
        System.out.println(saludo.hola);
    }

    @Before(value = "@BoToBeCreate")
    public void createBoard(){
        String body = "{\"name\" : \"Created from hook\"}";
        Response res = RequestManager.post("/1/boards", body);
        helper.response = res.as(Board.class);
        saludo.hola = "HOla Amelia";
        System.out.println(saludo.hola);
    }
}
