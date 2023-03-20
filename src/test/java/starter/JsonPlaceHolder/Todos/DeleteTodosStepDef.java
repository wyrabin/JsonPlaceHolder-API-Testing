package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;

public class DeleteTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id)
    {
        todoAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser()
    {
        SerenityRest.when().delete(TodoAPI.DELETE_TODOS);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id)
    {
        todoAPI.deleteInvalidUser(id);
    }
}
