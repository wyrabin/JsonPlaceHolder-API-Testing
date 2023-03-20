package starter.JsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class CommentsAPI {

    public static String GET_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String GET_COMMENTS_INVALID_PARAM = Constant.BASE_URL + "/comments/{param}";
    public static String GET_COMMENTS_WITHOUT_PARAM = Constant.BASE_URL;
    public static String POST_COMMENTS = Constant.BASE_URL + "/comments";
    public static String POST_COMMENTSID = Constant.BASE_URL + "/comments/{id}";
    public static String PUT_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String DELETE_COMMENTS = Constant.BASE_URL + "/comments/{id}";

    @Step("Get list comments valid id")
    public void getListComments(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list comments invalid id")
    public void getListCommentsInvalid(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list comments without parameter")
    public void getListWithoutParam() {
        SerenityRest.given();
    }

    @Step("Get list comments with invalid param")
    public void getListWithInvalidParam(String param) {
        SerenityRest.given().pathParam("param", param);
    }

    @Step("Post comments with valid json")
    public void postCommentsValidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post comments with valid id")
    public void postCommentsValidID(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Put update comments")
    public void putUpdateComments(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete comments with valid id")
    public void deleteComments(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete comments with invalid id")
    public void deleteCommentsInvalid(String id) {
        SerenityRest.given().pathParam("id", id);
    }
}
