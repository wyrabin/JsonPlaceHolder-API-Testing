package starter.JsonPlaceHolder.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.AlbumsAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutAlbumStepDef {

    @Steps
    AlbumsAPI albumsAPI;

    @Given("Put update album with valid json with id {int}")
    public void putUpdateAlbumWithValidJson(int id){
        File json = new File(Constant.ALBUMS_JSON_REQUEST+"/PutAlbumsRequest.json");
        albumsAPI.putUpdateAlbum(id,json);
    }
    @When("Send request put update album")
    public void sendRequestPutUpdateAlbum(){
        SerenityRest.when().put(AlbumsAPI.PUT_UPDATE_ALBUMS);
    }
    @And("Response body id user should be {int} and id {int} and title should be {string}")
    public void responseBodyIdShouldBe(int userID, int id,String title) {
        SerenityRest.then()
                .body(JPHResponses.ID_USER, equalTo(userID))
                .body(JPHResponses.ID, equalTo(id))
                .body(JPHResponses.TITLE, equalTo(title));


    }
    @Given("Put update album with invalid json with id {int}")
    public void putUpdateAlbumWithInvalidJson(int id){
        File json = new File(Constant.ALBUMS_JSON_REQUEST+"/PutAlbumInvalid.json");
        albumsAPI.putUpdateAlbum(id,json);
    }
    @Given("Put update album with blank json with id {int}")
    public void puttUpdateAlbumBlank(int id) {
        File json = new File(Constant.ALBUMS_JSON_REQUEST+"/PutAlbumBlank.json");
        albumsAPI.putUpdateAlbum(id,json);
    }
    @Given("Put update album with extra body json with id {int}")
    public void puttUpdateAlbumExtra(int id) {
        File json = new File(Constant.ALBUMS_JSON_REQUEST+"/PostAlbumWithExtra.json");
        albumsAPI.putUpdateAlbum(id,json);
    }
    @Given("Put update album with unregister id {int}")
    public void putUpdateAlbumUnregister(int id) {
        File json = new File(Constant.ALBUMS_JSON_REQUEST+"/PutAlbumWithUnregister.json");
        albumsAPI.putUpdateAlbum(id,json);
    }







//    @Given("Put update album with extra body json")
//    public void puttUpdateAlbumExtra() {
//        File json = new File(Constant.ALBUMS_JSON_SCHEMA + "/GetAlbumSchema.json");
//        albumsAPI.putAlbumBlank(json);
//    }




}
