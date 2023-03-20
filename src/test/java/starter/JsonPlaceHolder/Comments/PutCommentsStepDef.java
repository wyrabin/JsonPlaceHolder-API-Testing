package starter.JsonPlaceHolder.Comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.CommentsAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PutCommentsStepDef {

    @Steps
    CommentsAPI commentsAPI;

    @Given("Put comments with valid json with id {int}")
    public void putCommentsWithValidJsonWithId(int id) {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PutCommentsRequest.json");
        commentsAPI.putUpdateComments(id,json);
    }

    @When("Send request put comments")
    public void sendRequestPutComments() {
        SerenityRest.when().put(CommentsAPI.PUT_COMMENTS);

    }

    @Given("Put comments with invalid json with id {int}")
    public void putCommentsWithInvalidJsonWithId(int id) {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PutCommentsRequestInvalid.json");
        commentsAPI.putUpdateComments(id,json);
    }

    @Given("Put comments with unrequired object at json with id {int}")
    public void putCommentsWithUnrequiredObjectAtJsonWithId(int id) {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostUnrequiredObject.json");
        commentsAPI.putUpdateComments(id,json);
    }

    @Given("Put comments with valid parameter id {int}")
    public void putCommentsWithValidParameterId(int id) {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PutCommentsRequest.json");
        commentsAPI.putUpdateComments(id,json);
    }

    @When("Send request put comments with param")
    public void sendRequestPutCommentsWithParam() {
        SerenityRest.when().put(CommentsAPI.PUT_COMMENTS);
    }

    @Given("Post comments with blank json with id {int}")
    public void postCommentsWithBlankJsonWithId(int id) {
        File json = new File(Constant.COMMENTS_JSON_REQUEST+"/PostPutBlank.json");
        commentsAPI.putUpdateComments(id,json);
    }
}