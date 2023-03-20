package starter.JsonPlaceHolder.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.CommentsAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class PostCommentsStepDef {

    @Steps
    CommentsAPI commentsAPI;
    @Given("Post comments with valid json")
    public void postCommentsWithValidJson() {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostCommentsRequest.json");
        commentsAPI.postCommentsValidJson(json);

    }

    @When("Send request post comments")
    public void sendRequestGetPostComments() {
        SerenityRest.when().post(CommentsAPI.POST_COMMENTS);
    }

    @And("Response body page should be {int},{string},{string} and {string}")
    public void responseBodyPageShouldBePostIdAnd(int postId, String name, String email, String body) {
        SerenityRest.then()
                .body(JPHResponses.POSTID,equalTo(postId))
                .body(JPHResponses.NAME, equalTo(name))
                .body(JPHResponses.EMAIL,equalTo(email))
                .body(JPHResponses.BODY,equalTo(body));
    }
    @And("Validate json schema post comments")
    public void validateJsonSchemaPostComments() {
        File jsonSchema = new File(Constant.COMMENTS_JSON_SCHEMA+"/PostCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post comments with invalid json")
    public void postCommentsWithInvalidJson() {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostCommentsRequestInvalid.json");
        commentsAPI.postCommentsValidJson(json);
    }

    @Given("Post comments with unrequired object at json")
    public void postCommentsWithUnrequiredObjectAtJson() {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostUnrequiredObject.json");
        commentsAPI.postCommentsValidJson(json);
    }


    @Given("Post comments with valid parameter id {int}")
    public void postCommentsWithValidParameterId(int id) {
        commentsAPI.postCommentsValidID(id);
    }

    @When("Send request post comments with param")
    public void sendRequestPostCommentsWithParam() {
        SerenityRest.when().post(CommentsAPI.POST_COMMENTSID);
    }

    @Given("Post comments with blank json")
    public void postCommentsWithBlankJson() {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostPutBlank.json");
        commentsAPI.postCommentsValidJson(json);
    }
}
