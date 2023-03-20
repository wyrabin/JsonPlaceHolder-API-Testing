package starter.JsonPlaceHolder.Comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.CommentsAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

public class DeleteCommentsStepDef {
    @Steps
    CommentsAPI commentsAPI;

    @Given("Delete comments with valid parameter {int}")
    public void deleteCommentsWithValidParameterId(int id) {
        commentsAPI.deleteComments(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(CommentsAPI.DELETE_COMMENTS);
    }

    @Given("Delete comments with invalid parameter {string}")
    public void deleteCommentsWithInvalidParameter(String id) {
        commentsAPI.deleteCommentsInvalid(id);
    }
}
