package starter.JsonPlaceHolder.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.AlbumsAPI;

public class DeleteAlbumStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Delete albums with valid id {int}")
    public void deleteAlbumsWithValidId(int id) {albumsAPI.deleteAlbums(id);

    }

    @When("Send request delete album")
    public void sendRequestDeleteAlbum() {
        SerenityRest.when().delete(AlbumsAPI.DELETE_ALBUMS);
    }

    @Given("Delete albums with invalid id {int}")
    public void deleteAlbumsWithInValidId(int id) {albumsAPI.deleteAlbums(id);

    }

}
