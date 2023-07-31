package api;

import io.restassured.response.Response;
import serialization.LoginBody;
import util.ApiBase;

public class Auth {
    ApiBase apiBase = new ApiBase();


    public Response checkMobileNumber(LoginBody loginBody) {
        return apiBase.post(loginBody, "/v2/auth/mobile-check", ApiBase.Country.EGYPT);
    }
}
