package starter.JsonPlaceHolder.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.AlbumsAPI;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;
import starter.JsonPlaceHolder.Utils.JPHResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAlbumsStepDef {

    @Steps
    AlbumsAPI albumsAPI;

    @Given("Get list album with id {int}")
    public void getAlbumWithId(int id) {albumsAPI.getListAlbums(id); }

    @When("send request get albums")
    public void sendRequestGeAlbums() {
        SerenityRest.when().get(AlbumsAPI.GET_ALBUMS);

    }

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page should be id {int}")
    public void responseBodyPageShouldBeId(int id)
    {
        SerenityRest.then().body(JPHResponses.ID,equalTo(id));}

    @And("Validate json schema get albums")
    public void validateJsonSchemaListAlbums()
    {
        File jsonSchema = new File(Constant.ALBUMS_JSON_SCHEMA+"/GetAlbumsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list album with invalid id {int}")
    public void getAlbumWithInvalidId(int id) {albumsAPI.getListAlbums(id); }

//    @Given("Get list album")
//    public void getListAlbumss() {albumsAPI.getListAlbumsid();}
//    @When("send request get list albums")
//    public void sendRequestGeAlbumsid() {
//        SerenityRest.when().get(AlbumsAPI.GET_ALBUMS);
//
//    }

    }
