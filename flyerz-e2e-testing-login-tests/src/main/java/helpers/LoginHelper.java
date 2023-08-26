package helpers;
import api.Auth;
import io.restassured.response.Response;
import org.testng.Assert;
import serialization.LoginBody;

public class LoginHelper {
    Auth auth = new Auth();
    LoginBody loginBody = new LoginBody();
    private String otp;
    private boolean isPhoneVerified;
    private int statusCode;

    public void getOTP(){
        loginBody.setMobileNumber(loginBody.getMobileNumber());
        loginBody.setCountryCode(loginBody.getCountryCode());

        Response checkOTP = auth.checkFireBaseOTP(loginBody);
        System.out.println(checkOTP.then().log().body());

        statusCode = checkOTP.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is wrong");

        otp = checkOTP.getBody().jsonPath().getString("data.otp");
        Assert.assertNotEquals(otp, null, "Otp is retrieved Null");
        System.out.println(otp);
    }
    public void verifyLoginByOneAccount(){
        loginBody.setMobileNumber(loginBody.getMobileNumber());
        loginBody.setCountryCode(loginBody.getCountryCode());
        loginBody.setOtp(otp);

        Response checkLogin = auth.loginWithOneAccount(loginBody);
        System.out.println(checkLogin.then().log().body());

        statusCode = checkLogin.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status Code is Wrong!... ");
    }
    public void verifyRegistration(){
        loginBody.setMobileNumber(loginBody.getMobileNumber());
        loginBody.setCountryCode(loginBody.getCountryCode());
        loginBody.setOtp(otp);
        loginBody.setFirstName("Test");
        loginBody.setLastName("Elbana");
        loginBody.setCountryId(1);

        Response getRegistrationResponse = auth.registration(loginBody);
        System.out.println(getRegistrationResponse.then().log().body());

        statusCode = getRegistrationResponse.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
    }
    public void LoginAndRegistrationFlow(String mobileNumber, String countryCode) {
        loginBody.setMobileNumber(mobileNumber);
        loginBody.setCountryCode(countryCode);

        Response checkMobileNumber = auth.checkMobileNumber(loginBody);

        statusCode = checkMobileNumber.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is wrong");

        String getDescriptionMessage = checkMobileNumber.getBody().jsonPath().getString("data.description");
        Assert.assertNotEquals(getDescriptionMessage, null, "description message is retrieved Null");
        System.out.println(getDescriptionMessage);

        String getCountryCode;
        switch (getDescriptionMessage) {
            case "new user need to register his account" -> {
                getCountryCode = checkMobileNumber.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "3", "country code is not equal 3");
                isPhoneVerified = checkMobileNumber.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");

                getOTP();
                verifyRegistration();
            }
            case "Has One Phone and verified need to login" -> {
                getCountryCode = checkMobileNumber.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "2", "country code is not equal 2");
                isPhoneVerified = checkMobileNumber.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertTrue(isPhoneVerified, "phone is verified");

                getOTP();
                verifyLoginByOneAccount();
            }
            case "has one account and not verified need to login with facebook verification" -> {
                getCountryCode = checkMobileNumber.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "1", "country code is not equal 1");
                isPhoneVerified = checkMobileNumber.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");

                getOTP();
                verifyLoginByOneAccount();
            }
            case "user with multi accounts" -> {
                getCountryCode = checkMobileNumber.getBody().jsonPath().getString("data.code");
                System.out.println(getCountryCode);
                Assert.assertEquals(getCountryCode, "4", "country code is not equal 4");
                isPhoneVerified = checkMobileNumber.getBody().jsonPath().getBoolean("data.isPhoneVerified");
                System.out.println(isPhoneVerified);
                Assert.assertFalse(isPhoneVerified, "phone is verified");

                getOTP();
            }
        }
    }

}






