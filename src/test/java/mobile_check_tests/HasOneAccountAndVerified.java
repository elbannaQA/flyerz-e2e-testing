package mobile_check_tests;

import helpers.CheckMobileHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HasOneAccountAndVerified {
    CheckMobileHelper checkMobileHelper = new CheckMobileHelper();

    @DataProvider
    public Object[][] mobileNumbers() {
        return new Object[][]{
                {"+20", "1016467532"},
                {"+20", "1224084500"},
                {"+20", "1234567892"},
                {"+20", "1022466127"}
        };
    }

    @Test(dataProvider = "mobileNumbers")
    public void checkMobileVerification(String mobileNumber, String countryCode) {
        checkMobileHelper.hasOneAccountAndVerified(countryCode, mobileNumber);
    }


}
