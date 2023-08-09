package firebase_otp_tests;

import helpers.FireBaseHelper;
import helpers.LoginHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FireBaseOTPTests {
    FireBaseHelper fireBaseHelper = new FireBaseHelper();

    @DataProvider
    public Object[][] mobileNumbers(){
            return new Object[][]{
            {"1016467532","+20"}, //Egypt
                    {"7847973361","+964"}, //Iraq
                    {"65679654","+962"}, //Jordan
                    {"6139199400","+55"} //Brazil
        };
    }
    @Test(dataProvider = "mobileNumbers")
    public void verifyFireBaseOtpTests(String mobileNumbers, String countryCode){
        fireBaseHelper.checkFireBaseApiResponse(mobileNumbers,countryCode);
    }

}
