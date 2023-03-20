package starter.JsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class AlbumsAPI {


    public static String GET_ALBUMS = Constant.BASE_URL + "/albums?id={id}";
    public static String DELETE_ALBUMS = Constant.BASE_URL + "/albums/{id}";
    public static String POST_CREATE_ALBUMS = Constant.BASE_URL + "/albums";

    public static String PUT_UPDATE_ALBUMS = Constant.BASE_URL + "/albums/{id}";


    @Step("Get list albums")
    public void getListAlbums(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get list albums id")
    public void getListAlbumsid() {
        SerenityRest.given();
    }

    @Step("Delete albums")
    public void deleteAlbums(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post create albums")
    public void setPostCreateAlbums(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("put update album") // setiap yang ada parameternya kita harus input di dalam method nya contoh ada nya id disini
    public void putUpdateAlbum(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
//    @Step("Put album blank")
//    public void putAlbumBlank(File json) {
//        SerenityRest
//                .given()
//                .contentType(ContentType.JSON)
//                .body(json);
//    }





}
