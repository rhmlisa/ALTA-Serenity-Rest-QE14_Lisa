package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post Login with valid json {string}")
    public void postLoginWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postLoginUser(jsonFile);
    }
    @When("Send request Post Login User")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN);
    }

    @Given("Post Login with unregistered email on json {string}")
    public void postLoginWithUnregisteredEmailOnJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postLoginUser(jsonFile);
    }

    @Given("Post Login with invalid json {string}")
    public void postLoginWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postLoginUser(jsonFile);
    }
}
