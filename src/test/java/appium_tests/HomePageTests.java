package appium_tests;

import appium_pom.*;
import appium_util.AppiumBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomePageTests {
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();
    SignUpPage signUpPage = new SignUpPage();
    HomePage homePage = new HomePage();

    @BeforeTest
    public void init() throws MalformedURLException {
        AppiumBase appiumBase = new AppiumBase();
        appiumBase.appiumConfig();
    }
    @Test
    public void checkThatUserAbleToUseInvitationCode() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        signUpPage.signUpForInvitation("1124522820","Test"
                ,"Elbanna","123456");
        homePage.useInvitationCode("LL22");
    }
}
