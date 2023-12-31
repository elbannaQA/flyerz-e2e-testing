package api_util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static api_util.Config.url_stg;

public class ApiBase {
    public Response post(Object body, String endPoint, Country country) {
        RestAssured.baseURI = url_stg;
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", country.value)
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .extract().response();
    }
    public Response delete(String endPoint, Country country,  String value){
        RestAssured.baseURI = url_stg;
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+value)
                .header("country", country.value)
                .when()
                .delete()
                .then()
                .extract().response();
    }
    public enum Country {
        EGYPT("1"),
        BRAZIL("2"),
        JORDAN("115");
        private final String value;
        Country(String value) {
            this.value = value;
        }

    }
}
