package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesStepDef {
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(page));
    }
    @And("Response body should be {string}")
    public void responseBodyShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR_MESSAGE,equalTo(error));

    }
    @And("Response body id should be {int} and email is {string}")
    public void responseBodyIdShouldBeAndEmailIs(int id, String email) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body(ReqresResponses.DATA_EMAIL,equalTo(email));
    }
    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Response body page should {int} and per page should {int}")
    public void responseBodyPageShouldAndPerPageShould(int page, int per_page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE,equalTo(page))
                .body(ReqresResponses.PER_PAGE, equalTo(per_page));
    }
    @And("Response body id should {int} and name should {string}")
    public void responseBodyIdShouldAndNameShould(int id, String name) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body(ReqresResponses.DATA_NAME,equalTo(name));
    }
    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
