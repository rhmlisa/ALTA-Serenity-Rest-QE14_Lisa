package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {


    public static String LOGIN = Constants.BASE_URL + "/api/login";
    public static String REGISTER = Constants.BASE_URL + "/api/register";
    public static String CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String LIST_RESOURCE = Constants.BASE_URL + "/api/unknown";
    public static String SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";
    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    //Post Login
    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Post Register
    @Step("Post Register User")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Post Create User
    @Step("Post create user with valid json")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get ListUser
    @Step("Get list user with valid parameter page")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Get SingleUser
    @Step("Get Single user with user id")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get Single user with invalid user id")
    public void getSingleUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Get ListResource
    @Step("Get list resource")
    public void getListResource(){
        SerenityRest.given()
                .get(LIST_RESOURCE);
    }

    //Get SingleResource
    @Step("Get single resource")
    public void getSingleResource(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Put UpdateUser
    @Step("Update user with valid json and user id")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete User
    @Step("Delete User with valid user id")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete User with invalid user id")
    public void deleteUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

}
