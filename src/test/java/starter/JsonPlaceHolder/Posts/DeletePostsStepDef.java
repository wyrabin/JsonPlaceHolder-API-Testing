package starter.JsonPlaceHolder.Posts;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.PostsAPI;

public class DeletePostsStepDef {
    @Steps
    PostsAPI postsAPI;

    //scenario1
    @Given("Delete user with invalid {int}")
    public void deleteUserWithInvalidId(int id) {
        postsAPI.deleteUser(id);
    }


    //scenario2
    @Given("Delete posts with valid id {int}")
    public void deletePostsWithValidId(int id) {
        postsAPI.deleteUser(id);
    }
}