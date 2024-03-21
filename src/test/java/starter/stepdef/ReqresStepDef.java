package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when()
                .get(ReqresAPI.LIST_USERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    //Scenario 2
    @Given("Create user with valid json {string}")
    public void createUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonFile);
    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser() {
        SerenityRest.when()
                .post(ReqresAPI.CREATE_USER);
    }

    //Scenario 3
    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile );
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.UPDATE_USER);
    }

    @Given("Delete user with valid user id {int}")
    public void deleteUserWithValidUserId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
}
