package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with user id {int}")
    public void getSingleUserWithValidUserId(int id) {
        reqresAPI.getSingleUser(id);
    }
    @When("Send request get list single user")
    public void sendRequestGetListSingleUser() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_USER);
    }

    @Given("Get single user with non-existing user id {int}")
    public void getSingleUserWithNonExistingUserId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Given("Get single user with non-numeric user id {string}")
    public void getSingleUserWithNonNumericUserId(String id) {
        reqresAPI.getSingleUserInvalid(id);
    }
}
