package mobile_check_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.LoginBody;

import static org.hamcrest.Matchers.equalTo;

public class HasManyAccounts {
    private final String url = "https://flyerz-stg.convertedin.com/api";
    LoginBody loginBody = new LoginBody();

    @DataProvider()
    public static Object[][] mobileNumbers() {
        return new Object[][]{
                {"1022466127", "+20"},
        };
    }

    @Test(dataProvider = "mobileNumbers")
    public void checkMobileVerification(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody)
                .when()
                .post(url + "/v2/auth/mobile-check");

        response.then().log().body().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.code", equalTo(4))
                .body("data.isPhoneVerified", equalTo(false))
                .body("data.description", equalTo("user with multi accounts"));
    }

}
