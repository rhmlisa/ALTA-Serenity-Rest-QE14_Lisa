package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get all list resources with valid parameter id")
    public void getAllListResourcesWithValidParameterId() {
        reqresAPI.getListResource();
    }
    @When("Send request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when()
                .get(ReqresAPI.LIST_RESOURCE);
    }

    @Given("Get single resources with valid id {int}")
    public void getSingleResourcesWithValidId(int id) {
        reqresAPI.getSingleResource(id);
    }
    @When("Send request get single resources")
    public void sendRequestGetSingleResources() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_RESOURCE);
    }

    @Given("Get single resources with invalid id {int}")
    public void getSingleResourcesWithInvalidId(int id) {
        reqresAPI.getSingleResource(id);
    }
}
