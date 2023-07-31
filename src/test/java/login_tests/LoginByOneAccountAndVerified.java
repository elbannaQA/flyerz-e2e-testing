package login_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.ChannelsConnectionBody;
import serialization.LoginBody;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginByOneAccountAndVerified {
    private final String url = "https://flyerz-stg.convertedin.com/api";
    LoginBody loginBody = new LoginBody();
    ChannelsConnectionBody channelsConnection = new ChannelsConnectionBody();
    private String otp;
    private String apiToken;
    private Boolean isFaceBookConnected;

    @DataProvider()
    public static Object[][] mobileNumbers() {
        return new Object[][]{
                {"1016467532", "+20"},
        };
    }

    @DataProvider
    public static Object[][] channelsAndCategoryId() {
        return new Object[][]{
                {"1", "1"}
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
                .post(url + "/v2/auth/checkMobileNumber");
        response.then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("data.user", notNullValue())
                .body("data.user.firstName", notNullValue())
                .body("data.user.lastName", notNullValue())
                .body("data.user.email.email", equalTo("m.ahmed@converted.in"))
                .body("data.user.email.isVerified", equalTo(true))
                .body("data.user.mobileNumber.number", equalTo(loginBody.getMobileNumber()))
                .body("data.user.mobileNumber.isVerified", equalTo(true))
                .body("data.user.country.id", equalTo(1))
                .body("data.user.country.name", equalTo("مصر"))
                .body("data.user.currency.id", equalTo(1))
                .body("data.user.currency.name", equalTo("EGP"))
                .body("data.user.currency.symbol", equalTo(1));

        apiToken = response.getBody().jsonPath().getString("data.apiToken");
        System.out.println(apiToken);
    }

    @Test(dependsOnMethods = {"receiveOTP", "loginWithVerifiedAccount"})
    public void checkIfFaceBookConnectedIsTrue() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .header("Authorization", "Bearer " + apiToken)
                .when()
                .get(url + "/v2/users/connections/details");

        response.then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

        isFaceBookConnected = response.getBody().jsonPath().getBoolean("data.isFacebookConnected");
        System.out.println(isFaceBookConnected);
    }

    @Test(dependsOnMethods = {"receiveOTP", "loginWithVerifiedAccount", "checkIfFaceBookConnectedIsTrue"}
            , dataProvider = "channelsAndCategoryId")
    public void checkConnectionToFaceBookChannel(String channelId, String categoryId) {
        channelsConnection.setChannelId(channelId);
        channelsConnection.setCategoryId(categoryId);
        channelsConnection.getFaceBookAccessToken();
        channelsConnection.getFacebookPageId();

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("country", "1")
                .header("Authorization", "Bearer " + apiToken)
                .body(channelsConnection).log().body()
                .when()
                .post(url + "/v2/channels/connect");

        response.then()
                .log().body();

    }


}
