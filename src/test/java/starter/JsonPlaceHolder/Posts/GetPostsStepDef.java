package starter.JsonPlaceHolder.Posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.PostsAPI;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetPostsStepDef {

    @Steps
    PostsAPI postsAPI;

    //scenario1
    @Given("Get list user")
    public void getListUser() {
        postsAPI.getListUsersAll();
    }


    //scenario2
    @Given("Get list user with {int}")
    public void getListUserWithPage(int id) {
        postsAPI.getListUsers(id);
    }

    @And("Response body should page should be {int}")
    public void responseBodyPageShouldBe(int id) {
        SerenityRest.then().body(JPHResponses.ID, equalTo(id));
    }

    @When("Send request get list user without id")
    public void sendRequestGetListUserWithoutId() {
        SerenityRest.when().get(PostsAPI.GET_POSTS2);
    }


    //scenario3
    @Given("Get list user with invalid {string}")
    public void getListUserWithInvalid(String id) {
        postsAPI.getListUsersInvalid(id);
    }


    //scenario4
    @Given("Get list user with invalid parameter id")
    public void getListUserWithInvalidParameterId() {
        postsAPI.getInvalidParameterID();
    }

    @When("Send request with invalid parameter id")
    public void sendRequestWithInvalidParameterId() {
        SerenityRest.when().get(PostsAPI.GET_POSTS3);
    }


}