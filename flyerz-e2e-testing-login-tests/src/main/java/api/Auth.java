package api;

import io.restassured.response.Response;
import serialization.LoginBody;
import api_util.ApiBase;

public class Auth {
    ApiBase apiBase = new ApiBase();


    public Response checkMobileNumber(LoginBody loginBody) {
        return apiBase.post(loginBody, "/v2/auth/mobile-check", ApiBase.Country.EGYPT);
    }
    public Response checkFireBaseOTP(LoginBody loginBody){
        return apiBase.post(loginBody,"/mobile-verification/firebase/verify", ApiBase.Country.EGYPT);
    }
    public Response loginWithOneAccount(LoginBody loginBody){
        return apiBase.post(loginBody,"/v2/auth/login", ApiBase.Country.EGYPT);
    }
    public Response registration(LoginBody loginBody){
        return apiBase.post(loginBody,"/v2/auth/registration", ApiBase.Country.EGYPT);
    }
}
