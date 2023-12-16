package helpers;

import api.Auth;
import io.restassured.response.Response;
import org.testng.Assert;
import serialization.LoginBody;

public class FireBaseHelper {
    Auth auth = new Auth();
    LoginBody loginBody = new LoginBody();

    public void checkFireBaseApiResponse(String mobileNumber, String countryCode){
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response getFireBaseResponse = auth.checkFireBaseOTP(loginBody);
        System.out.println(getFireBaseResponse.then().log().body());

        int statusCode = getFireBaseResponse.getStatusCode();
        Assert.assertEquals(statusCode,200,"Status code is not 200");

        String otp = getFireBaseResponse.getBody().jsonPath().getString("data.otp");
        Assert.assertNotEquals(otp, null, "OTP is returned = null");

    }
}
