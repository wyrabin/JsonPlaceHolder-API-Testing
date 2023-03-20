package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PutTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Put update todos with valid json body and id {int}")
    public void putUpdateTodosWithValidJson(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPutTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos")
    public void sendRequestPutUpdateTodos()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with difference userID and id {int}")
    public void putUpdateTodosWithDifferenceUserIDAndIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/DiffUserIdAndIdTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with difference userID and id")
    public void sendRequestPutUpdateTodosWithDifferenceUserIDAndId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with blank body and with id {int}")
    public void putUpdateTodosWithBlankBodyAndIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/BlankBodyTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with blank body")
    public void sendRequestPutUpdateTodosWithBlankBodyAndId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with extra body category and with id {int}")
    public void putUpdateTodosWithExtraBodyCategoryAndIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ExtraBodyTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with extra body category")
    public void sendRequestPutUpdateTodosWithExtraBodyCategoryAndId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with invalid body data type and with id {int}")
    public void putUpdateTodosWithInvalidBodyDataTypeAndIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/InvalidDataTypeTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with invalid body data type")
    public void sendRequestPutUpdateTodosWithInvalidBodyDataTypeAndId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with invalid body category and with id {int}")
    public void putUpdateTodosWithInvalidBodyCategoryAndWithIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/InvalidBodyCategoryTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with invalid body category")
    public void sendRequestPutUpdateTodosWithInvalidBodyCategory()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos without id {int}")
    public void putUpdateTodosWithoutId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPutTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos without id")
    public void sendRequestPutUpdateTodosWithoutId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Then("Should return status code {int} Internal Server Error")
    public void shouldReturnStatusCodeInternalServerError(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Put update todos with unregistered id {int}")
    public void putUpdateTodosWithUnregisteredIdId(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPutTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos with unregistered id")
    public void sendRequestPutUpdateTodosWithUnregisteredId()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put update todos with invalid id {string} as string")
    public void putUpdateTodosWithInvalidIdAsString(String id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPutTodos.json");
        todoAPI.setPutUpdateTodosWithString(id,json);
    }


    @When("Send request put update todos with invalid id as string")
    public void sendRequestPutUpdateTodosWithInvalidIdAsString()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }
}
