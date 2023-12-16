package helpers;

import api.Auth;
import io.restassured.response.Response;
import org.testng.Assert;
import serialization.LoginBody;

public class DeleteUsersHelper {

    Auth auth = new Auth();
    LoginBody loginBody = new LoginBody();

    public void deleteUsers(String mobileNumber, String countryCode){
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response getFireBaseResponse = auth.checkFireBaseOTP(loginBody);
        System.out.println(getFireBaseResponse.then().log().body());

        int statusCode = getFireBaseResponse.getStatusCode();
        Assert.assertEquals(statusCode,200,"Status code is not 200");

        String otp = getFireBaseResponse.getBody().jsonPath().getString("data.otp");
        Assert.assertNotEquals(otp, null, "OTP is returned = null");

        loginBody.setOtp(otp);

        Response userLoggedIn = auth.loginWithOneAccount(loginBody);
       System.out.println(userLoggedIn.then().log().body());

       String apiToken = userLoggedIn.getBody().jsonPath().getString("data.apiToken");
        System.out.println(apiToken);

        Response deleteUsers = auth.delete(apiToken);
       System.out.println(deleteUsers.then().log().body());

    }

}
