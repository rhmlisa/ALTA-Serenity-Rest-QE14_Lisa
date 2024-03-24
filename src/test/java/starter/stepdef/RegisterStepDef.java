package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post Register user with valid json {string}")
    public void postRegisterUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postRegisterUser(jsonFile);
    }
    @When("Send request Post Register User")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER);
    }

    @Given("Post Register user with invalid data on json {string}")
    public void postRegisterUserWithInvalidDataOnJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.postRegisterUser(jsonFile);
    }
}
