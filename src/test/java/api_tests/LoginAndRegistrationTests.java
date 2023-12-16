package api_tests;

import helpers.LoginHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

public class LoginAndRegistrationTests {

    LoginHelper loginHelper = new LoginHelper();
    @DataProvider
    public Object[][] mobileNumbers() {
        return new Object[][]{
                {"1016467532", "+20"},
                {"1224084500", "+20"},
                {"1234567892", "+20"},
                {"1022466127", "+20"}
        };
    }

    @Test(dataProvider = "mobileNumbers")
    public void checkLoginByOneAccountAndVerified(String mobileNumber, String countryCode){
        loginHelper.LoginAndRegistrationFlow(mobileNumber,countryCode);
    }


}
