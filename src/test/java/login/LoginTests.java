package login;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.LoginBody;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class LoginTests {
    private static final ThreadLocal<String> otpThreadLocal = new ThreadLocal<>();
    private final String url = "https://flyerz-stg.convertedin.com/api";
    LoginBody loginBody = new LoginBody();
    private String otp;

    //    @BeforeClass
//    public static void createRequestSpecifications(){
//        requestSpec = new RequestSpecBuilder().
//                setBaseUri("https://flyerz-stg.convertedin.com/api/mobile-verification/firebase/verify").
//                addPathParams("mobileNumber", "1016467532").
//                addPathParams("countryCode","20").
//                build();
//    }

    @DataProvider()
    public static Object[][] mobileNumbers() {
        return new Object[][]{
                {"1016467532", "+20"},
//                {"8823004984", "+55"},
//                {"64903803" , "+962"}
        };
    }


    @Test(dataProvider = "mobileNumbers")
    public void receiveOTP(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody)
                .when()
                .post(url + "/mobile-verification/firebase/verify");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        otp = response.getBody().jsonPath().getString("data.otp");

        System.out.println(otp);
    }

    @Test(dependsOnMethods = {"receiveOTP"}, dataProvider = "mobileNumbers")
    public void loginWithVerifiedAccount(String mobileNumber, String countryCode) {

        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);
        loginBody.setOtp(otp);


        System.out.println(otp);
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .body(loginBody).log().body()
                .when()
                .post(url + "/v2/auth/login");
        response.then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("data.user", notNullValue())
                .body("data.user.firstName", notNullValue())
                .body("data.user.lastName", notNullValue())
                .body("data.user.email.email", equalTo("m.ahmed@converted.in"))
                .body("data.user.mobileNumber.number", equalTo(loginBody.getMobileNumber()));

    }


}
