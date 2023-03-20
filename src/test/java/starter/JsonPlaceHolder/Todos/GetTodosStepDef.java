package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class GetTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Get todos with id {int}")
    public void getListTodosWithId(int id)
    {
        todoAPI.setGetListTodos(id);
    }

    @When("Send request get list todos with selected id")
    public void sendRequestGetListTodosWithId()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS);
    }

    @When("Send request get list todos with selected id out of range")
    public void sendRequestGetListTodosWithIdOutOfRange()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_2);
    }

    @Then("Should return status code {int} ok")
    public void shouldReturnStatusCodeOk(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

//    @And("Response body page should be id {int}")
//    public void responseBodyPageShouldBeId(int id)
//    {
//        SerenityRest.then().body(JPHResponses.ID,equalTo(id));
////        SerenityRest.then().body("id", equalTo(id));
////        int actualId = JsonPath.from(SerenityRest.then().extract().asString()).getInt("id");
////        Assertions.assertThat(actualId).isEqualTo(id);
//    }

    @And("Validate json schema list todos")
    public void validateJsonSchemaListTodos()
    {
        File jsonSchema = new File(Constant.TODO_JSON_SCHEMA+"/GetTodosSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //test case negative
    @Given("Get todos with invalid parameter id {string} as string")
    public void getListTodosWithId(String id)
    {
        todoAPI.getListTodosInvalid(id);
    }

    @Then("Should return status code {int} Bad Request")
    public void shouldReturnStatusCodeBadRequest(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Get todos without id")
    public void getTodosWithoutId()
    {
        SerenityRest.given().get(TodoAPI.POST_TODOS);
    }

    @When("Send request get list todos without id")
    public void sendRequestGetListTodosWithoutId()
    {
        SerenityRest.when().get(TodoAPI.POST_TODOS);
    }

    @Given("Get todos with id {int} and modified parameter {string}")
    public void getTodosWithIdIdAndModifiedParameter(int id, String title)
    {
        todoAPI.setGetTodos3(id,title);
    }

    @When("Send request get todos with selected id and parameter")
    public void sendRequestGetTodosWithSelectedIdAndParameter()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_3);
    }

    @Given("Get todos with invalid id {string}")
    public void getTodosWithInvalidId(String id)
    {
        todoAPI.getListTodosInvalid(id);
    }

    @When("Send request get todos with selected id")
    public void sendRequestGetTodosWithSelectedId()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_2);
    }

    @And("Validate json schema lists todos")
    public void validateJsonSchemaListsTodos()
    {
        File jsonSchema = new File(Constant.TODO_JSON_SCHEMA+"/PostTodosSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body id should be {int}")
    public void responseBodyPageShouldBeId(int id)
    {
        SerenityRest.then()
                .body(JPHResponses.ID, Matchers.instanceOf(List.class));
    }

    @And("Response body id should be {int} and response body title should be {string}")
    public void responseBodyIdShouldBeIdAndResponseBodyTitleShouldBe(int id, String title)
    {
        SerenityRest.then()
                .body(JPHResponses.ID, Matchers.instanceOf(List.class))
                .body(JPHResponses.TITLE, Matchers.instanceOf(List.class));
    }
}
