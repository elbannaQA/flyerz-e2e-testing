package api_tests;

import helpers.DeleteUsersHelper;
import helpers.FireBaseHelper;
import helpers.LoginHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.LoginBody;

import static api_util.Config.url_stg;

public class DeleteUsersTests {
   FireBaseHelper fireBaseHelper = new FireBaseHelper();
   DeleteUsersHelper deleteUsersHelper = new DeleteUsersHelper();
   LoginHelper loginHelper = new LoginHelper();
   LoginBody loginBody = new LoginBody();



    @Test
    public void checkUserIsDeletedSuccessfully(){
        fireBaseHelper.checkFireBaseApiResponse("1124522820","1");
        deleteUsersHelper.deleteUsers("1124522820","1");
    }

    @Test
    public void deleteUserTest(){
        RestAssured.baseURI = url_stg;
        loginBody.setMobileNumber("1124522820");
        loginBody.setCountryCode("1");
       Response response =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody)
                .when()
                .post("/mobile-verification/firebase/verify")
                .then()
                .extract().response();

        String otp = response.getBody().jsonPath().getString("data.otp");
        System.out.println(otp);

        loginBody.setMobileNumber("1124522820");
        loginBody.setCountryCode("1");
        loginBody.setOtp(otp);
        Response response1 = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody)
                .when()
                .post("/v2/auth/login")
                .then()
                .extract().response();

        String
                apiToken = response1.getBody().jsonPath().getString("data.apiToken");
        System.out.println(apiToken);

        Response response2 = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country","1")
                .header("Authorization","Bearer "+ apiToken)
                .when()
                .delete("/v2/users/delete")
                .then()
                .extract().response();
        System.out.println(response2.then().log().body());
    }


}
