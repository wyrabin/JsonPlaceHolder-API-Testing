package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class PostTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Post create todos with valid json")
    public void postCreateUserWithValidJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPostTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with valid json")
    public void sendRequestPostTodosWithValidJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }


    @Then("Should return status code {int} Created")
    public void shouldReturnStatusCodeCreated(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Post create todos with blank parameter json")
    public void postCreateTodosWithBlankParameterJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/BlankBodyTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with blank parameter json")
    public void sendRequestPostTodosWithBlankParameterJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }

    @Given("Post create todos with extra body category json")
    public void postCreateTodosWithExtraBofyCategoryJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ExtraBodyTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with extra body category json")
    public void sendRequestPostTodosWithExtraBofyCategoryJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }

    @Given("Post create todos with invalid body data type  json")
    public void postCreateTodosWithBodyDataTypeJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/InvalidDataTypeTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with invalid body data type json")
    public void sendRequestPostTodosWithInvalidBodyDataTypeJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }

    @Given("Post create todos with invalid body category json")
    public void postCreateTodosWithInvalidBodyCategoryJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/InvalidBodyCategoryTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with invalid body category json")
    public void sendRequestPostTodosWithInvalidBodyCategoryJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }

    @And("Response body id should be {int} and title should be {string}")
    public void responseBodyIdShouldBeIdAndResponseBodyTitleShouldBe(int id, String title)
    {
        SerenityRest.then()
                .body(JPHResponses.ID,equalTo(id))
                .body(JPHResponses.TITLE,equalTo(title));
    }
}
