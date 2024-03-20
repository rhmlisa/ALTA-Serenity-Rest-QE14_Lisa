package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {


    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";

    public static String CREATE_USER = Constants.BASE_URL + "/api/users";
    @Step("Get list user with valid parameter page")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user with valid json")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }
}
