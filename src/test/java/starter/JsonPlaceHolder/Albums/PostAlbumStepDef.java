package starter.JsonPlaceHolder.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.AlbumsAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostAlbumStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Post create albums with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/GetAlbumsRequest.json");
        albumsAPI.setPostCreateAlbums(json);
    }

    @When("Send request post create albums")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(AlbumsAPI.POST_CREATE_ALBUMS);
    }


    @And("Validate json schema create albums")
    public void validateJsonSchemaCreateAlbums()
    {
        File jsonSchema = new File(Constant.ALBUMS_JSON_SCHEMA+"/GetAlbumsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @Given("Post create albums with invalid json")
    public void postCreateUserWithInValidJson() {
        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/PostAlbumInvalid.json");
        albumsAPI.setPostCreateAlbums(json);
    }
    @Given("Post create albums with same body json")
    public void postCreateUserWithSamebody() {
        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/PostAlbumWithSameBody.json");
        albumsAPI.setPostCreateAlbums(json);
    }

    @Given("Post create albums with blank body json")
    public void postCreateUserWithBlank() {
        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/PostAlbumWithBlank.json");
        albumsAPI.setPostCreateAlbums(json);
    }

    @Given("Post create albums with extra parameter body json")
    public void postCreateUserWithExtra() {
        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/PostAlbumWithExtra.json");
        albumsAPI.setPostCreateAlbums(json);
    }





//    @Given("Post create albums with valid json object")
//    public void postCreateUserWithValidJsonObject() {
//        File json = new File(Constant.ALBUMS_JSON_REQUEST + "/PostAlbumValidObjec.json");
//        albumsAPI.setPostCreateAlbums(json);
//    }
//    @When("Send request post create albums object")
//    public void sendRequestPostCreateUserObject() {
//        SerenityRest.when().post(AlbumsAPI.POST_CREATE_ALBUMS);
//    }
//
//    @And("Validate json schema create albums object")
//    public void validateJsonSchemaCreateAlbumsObject()
//    {
//        File jsonSchema = new File(Constant.ALBUMS_JSON_SCHEMA+"/PostAlbumSchemaObject.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//
//    }

}

