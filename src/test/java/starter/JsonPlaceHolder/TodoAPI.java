package starter.JsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class TodoAPI
{
    public static String GET_TODOS = Constant.BASE_URL + "/todos?id={id}";
    public static String POST_CREATE_TODOS = Constant.BASE_URL + "/todos";
    public static String GET_TODOS_2 = Constant.BASE_URL + "/todos/{id}";
    public static String GET_TODOS_3 = Constant.BASE_URL + "/todos/?id={id}&title={title}";
    public static String POST_TODOS = Constant.BASE_URL + "/todos";
    public static String DELETE_TODOS = Constant.BASE_URL+"/todos/{id}";
    public static String PUT_UPDATE_TODOS = Constant.BASE_URL+"/todos/{id}";

    @Step("Get list todos")
    public void setGetListTodos(int id)
    {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list todos with modified parameter")
    public void setGetTodos3(int id, String title)
    {
        SerenityRest.given()
                .pathParam("id", id)
                .pathParam("title", title);
    }

    @Step("Post todos")
    public void setPostTodos(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id)
    {
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete invalid user")
    public void deleteInvalidUser(String id)
    {
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Put update todos")
    public void setPutUpdateTodos(int id, File json)
    {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update todos with string")
    public void setPutUpdateTodosWithString(String id, File json)
    {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get list todos invalid")
    public void getListTodosInvalid(String id)
    {
        SerenityRest.given().pathParam("id",id);
    }
}
