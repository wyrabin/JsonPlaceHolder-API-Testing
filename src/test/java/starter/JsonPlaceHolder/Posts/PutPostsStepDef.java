package starter.JsonPlaceHolder.Posts;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.PostsAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PutPostsStepDef {
    @Steps
    PostsAPI postsAPI;

    //scenario1
    @Given("Put update user with valid json with {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/RequestUser.json");
        postsAPI.putUpdateUser(id, json);
    }

    //scenario2
    @Given("Put update user with invalid json with {int} and blank body json")
  public void putUpdateUserWithInvalidJsonWithId(int id) {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidBlank.json");
        postsAPI.putUpdateUser(id, json);
    }

    //Scenario3
    @Given("Put update user with invalid json with {int} and invalid type data body json")
    public void putUpdateUserWithInvalidJsonWith(int id) {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidTypeData.json");
        postsAPI.putUpdateUser(id, json);
    }
    //Scenario4
    @Given("Put update user with invalid json with id {int} and extra body json")
    public void putUpdateUserWithInvalidJsonWithIdAndExtraBodyJson(int id) {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/extraPost.json");
        postsAPI.putUpdateUser(id, json);
    }

    //Scenario5
    @Given("Put update user with invalid json with id {int} and less category body")
    public void putUpdateUserWithInvalidJsonWithIdAndLessCategoryBody(int id) {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidLessCategory.json");
        postsAPI.putUpdateUser(id, json);
    }

}