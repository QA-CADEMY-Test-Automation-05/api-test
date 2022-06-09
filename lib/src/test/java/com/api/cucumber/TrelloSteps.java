package com.api.cucumber;

import com.api.RequestManager;
import com.api.TrelloObject.Board;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrelloSteps {

    private Helper helper;
    private Saludo saludo;

    public TrelloSteps(Helper helper, Saludo saludo){
        this.helper = helper;
        this.saludo = saludo;
    }

    @Given("I have the endpoint {string}")
    public void iHaveTheEndpoint(String endPointParam) {
        if (endPointParam.contains("[id]")){
            helper.endpoint = endPointParam.replace("[id]", helper.response.getId());
        }else {
            helper.endpoint = endPointParam;
        }
        System.out.println(saludo.hola);
        saludo.hola = "Hola Claudia";
    }

    @When("I send a {string}")
    public void iSendA(String methodParam) {
        if (methodParam.equalsIgnoreCase("GET")){
            helper.res = RequestManager.get(helper.endpoint);
        }
        if (methodParam.equalsIgnoreCase("POST")){
            helper.res = RequestManager.post(helper.endpoint, helper.body);
            helper.response = helper.res.as(Board.class);
        }
        if (methodParam.equalsIgnoreCase("PUT")){
            helper.res = RequestManager.put(helper.endpoint, helper.body);
        }
    }

    @Then("I expect the status code {int}")
    public void iExpectTheStatusCode(int expectStatusCode) {
        Assert.assertEquals("isnot expected",expectStatusCode,  helper.res.statusCode());
    }

    @And("I have a body {string}")
    public void iHaveABody(String bodyParam) {
        helper.body = bodyParam;
    }
}
