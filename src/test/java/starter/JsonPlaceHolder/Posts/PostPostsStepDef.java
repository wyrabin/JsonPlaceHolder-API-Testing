package starter.JsonPlaceHolder.Posts;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.PostsAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PostPostsStepDef {
    @Steps
    PostsAPI postsAPI;

    //scenario1
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/RequestUser.json");
        postsAPI.postCreateUser(json);
    }

    //scenario2
    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidBlank.json");
        postsAPI.postCreateUser(json);
    }

    //scenario3
    @Given("Post create user with extra json")
    public void postCreateUserWithExtraJson() {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/extraPost.json");
        postsAPI.postCreateUser(json);
    }

    //scenario4
    @Given("Post create user with invalid type data body")
    public void postCreateUserWithInvalidTypeDataBody() {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidTypeData.json");
        postsAPI.postCreateUser(json);
    }
    //scenario5
    @Given("Post create user with less category body")
    public void postCreateUserWithLessCategoryBody() {
        File json = new File(Constant.POSTS_JSON_REQUEST + "/invalidLessCategory.json");
        postsAPI.postCreateUser(json);
    }

}