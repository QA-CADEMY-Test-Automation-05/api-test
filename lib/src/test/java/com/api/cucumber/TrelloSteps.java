package com.api.cucumber;

import com.api.RequestManager;
import com.api.TrelloObject.Board;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TrelloSteps {

    String endpoint = "";
    Response res = null;
    String body = "";
    Board response = null;

    @Given("I have the endpoint {string}")
    public void iHaveTheEndpoint(String endPointParam) {
        if (endPointParam.contains("[id]")){
            endpoint = endPointParam.replace("[id]", response.getId());
        }else {
            endpoint = endPointParam;
        }
    }

    @When("I send a {string}")
    public void iSendA(String methodParam) {
        if (methodParam.equalsIgnoreCase("GET")){
            res = RequestManager.get(endpoint);
        }
        if (methodParam.equalsIgnoreCase("POST")){
            res = RequestManager.post(endpoint, body);
            response = res.as(Board.class);
        }
        if (methodParam.equalsIgnoreCase("PUT")){
            res = RequestManager.put(endpoint, body);
        }
    }

    @Then("I expect the status code {int}")
    public void iExpectTheStatusCode(int expectStatusCode) {
        Assert.assertEquals("isnot expected",expectStatusCode,  res.statusCode());
    }

    @And("I have a body {string}")
    public void iHaveABody(String bodyParam) {
        body = bodyParam;
    }
}
