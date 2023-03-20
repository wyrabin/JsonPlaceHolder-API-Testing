package starter.JsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PostsAPI {

    public static String GET_POSTS = Constant.BASE_URL + "/posts/{id}";
    public static String GET_POSTS2 = Constant.BASE_URL + "/posts/";
    public static String GET_POSTS3 = Constant.BASE_URL + "/posts?id=bnvg";
    public static String POST_POSTS= Constant.BASE_URL + "/posts";
    public static String PUT_POSTS = Constant.BASE_URL + "/posts/{id}";
    public static String DELETE_POSTS = Constant.BASE_URL + "/posts/{id}"; //untuk URL delete user



    //METHOD
    @Step("Get list users") //valid get list user
    public void getListUsers(int id) {

        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get all list user")
    public void getListUsersAll() {
        SerenityRest.given();
    }

    @Step("Get invalid parameter id")
    public void getInvalidParameterID(){
        SerenityRest.given();
    }

    @Step("Post create user invalid")
    public void postCreateUserInvalidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("list user invalid")
    public void getListUsersInvalid(String id) {
        SerenityRest.given().pathParam("id", id);
    }
}
