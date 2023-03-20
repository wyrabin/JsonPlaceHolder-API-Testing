package starter.JsonPlaceHolder.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.CommentsAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetCommentsStepDef {

    @Steps
    CommentsAPI commentsAPI;


    @Given("Get comments with valid parameter {int}")
    public void getCommentsWithValidParameterId(int id) {
        commentsAPI.getListComments(id);
    }
    @When("Send request get list comments")
    public void sendRequestGetListComments() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS);
    }

    @Then("Should return comments with status code {int}")
    public void shouldReturnCommentsWithStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBeId(int id) {
        SerenityRest.then().body(JPHResponses.ID, equalTo(id));
    }

    @And("Validate json schema list comments")
    public void validateJsonSchemaListComments() {
        File jsonSchema = new File(Constant.COMMENTS_JSON_SCHEMA+"/GetCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get comments with valid parameter {string}")
    public void getCommentsWithValidParameter(String id) {
        commentsAPI.getListCommentsInvalid(id);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBe(String id) {
        SerenityRest.then().body(JPHResponses.ID, equalTo(id));
    }

    @Given("Get comments without any parameter")
    public void getCommentsWithoutAnyParameter() {
        commentsAPI.getListWithoutParam();
    }

    @When("Send request get list comments without param")
    public void sendRequestGetListCommentsWithoutParam() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS_WITHOUT_PARAM);
    }

    @And("Response body page should be page")
    public void responseBodyPageShouldBePage() {
        SerenityRest.then();
    }

    @Given("Get comments with invalid {string}")
    public void getCommentsWithInvalidParameter(String param) {
        commentsAPI.getListWithInvalidParam(param);
    }

    @When("Send request get list comment invalid param")
    public void sendRequestGetListCommentInvalidParam() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS_INVALID_PARAM);
    }
}