package starter.JsonPlaceHolder.Posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.PostsAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class GeneraPostslStepDef {

    @Steps
    PostsAPI postsAPI;


    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(PostsAPI.GET_POSTS);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(PostsAPI.POST_POSTS);
    }

    @When("Send post request to delete user")
    public void sendPostRequestToDeleteUser() {
        SerenityRest.when().delete(PostsAPI.DELETE_POSTS);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(PostsAPI.PUT_POSTS);
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
        File jsonSchema = new File(Constant.POSTS_JSON_SCHEMA+"/POSTSSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
