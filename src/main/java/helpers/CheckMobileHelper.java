package helpers;

import api.Auth;
import io.restassured.response.Response;
import org.testng.Assert;
import serialization.LoginBody;

public class CheckMobileHelper {
    Auth auth = new Auth();
    LoginBody loginBody = new LoginBody();


    public void hasOneAccountAndVerified(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response login = auth.checkMobileNumber(loginBody);

        int statusCode = login.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is wrong");

        String getDescriptionMessage = login.getBody().jsonPath().getString("data.description");
        Assert.assertNotEquals(getDescriptionMessage, null, "description message is retrieved Null");
        System.out.println(getDescriptionMessage);

        String getCountryCode;
        boolean isPhoneVerified;

        switch (getDescriptionMessage) {
            case "new user need to register his account" -> {
                getCountryCode = login.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "3", "country code is not equal 3");
                isPhoneVerified = login.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");
            }
            case "Has One Phone and verified need to login" -> {
                getCountryCode = login.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "2", "country code is not equal 2");
                isPhoneVerified = login.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertTrue(isPhoneVerified, "phone is verified");
            }
            case "has one account and not verified need to login with facebook verification" -> {
                getCountryCode = login.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "1", "country code is not equal 1");
                isPhoneVerified = login.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");
            }
            case "user with multi accounts" -> {
                getCountryCode = login.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "4", "country code is not equal 4");
                isPhoneVerified = login.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");
            }
        }
    }
}






