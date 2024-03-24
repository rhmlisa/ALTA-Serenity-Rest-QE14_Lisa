package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteStefDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with valid user id {int}")
    public void deleteUserWithValidUserId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Given("Delete user with invalid user id {int}")
    public void deleteUserWithInvalidUserId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with non-numeric user id {string}")
    public void deleteUserWithNonNumericUserId(String id) {
        reqresAPI.deleteUserInvalid(id);
    }
}
