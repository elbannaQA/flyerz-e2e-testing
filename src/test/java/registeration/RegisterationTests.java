package registeration;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.LoginBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegisterationTests {
    private final String url = "https://flyerz-stg.convertedin.com/api";
    LoginBody loginBody = new LoginBody();
    private String otp;


    @DataProvider()
    public static Object[][] mobileNumbers() {
        return new Object[][]{
                {"8823004984", "+55"},
        };
    }

    @Test(dataProvider = "mobileNumbers")
    public void receiveOTP(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody)
                .when()
                .post(url + "/mobile-verification/firebase/verify");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        otp = response.getBody().jsonPath().getString("data.otp");

        System.out.println(otp);
    }

    @Test(dependsOnMethods = "receiveOTP", dataProvider = "mobileNumbers")
    public void registerAsAnewUser(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);
        loginBody.setCountryId(1);
        loginBody.setOtp(otp);
        loginBody.setFirstName("Test");
        loginBody.setLastName("Elbanna");

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("country", 1)
                        .body(loginBody).log().body()
                        .when()
                        .post(url + "/v2/auth/registration");

        response
                .then()
                .log().body()
                .assertThat()
                .body("message", equalTo("رقم الهاتف المحمول قيد الاستخدام بالفعل."))
                .statusCode(400)
                .contentType(ContentType.JSON);

    }


}
