package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateStefDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with valid user id {} and json {string}")
    public void updateUserWithValidUserIdAndJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile );
    }
    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.UPDATE_USER);
    }

    @Given("Update user with non-existing user id {} and valid json {string}")
    public void updateUserWithNonExistingUserIdAndValidJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile );
    }

    @Given("Update user with user id {int} without name on json {string}")
    public void updateUserWithUserIdWithoutNameOnJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile );
    }

    @Given("Update user with user id {int} without job on json {string}")
    public void updateUserWithUserIdWithoutJobOnJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile );
    }
}
