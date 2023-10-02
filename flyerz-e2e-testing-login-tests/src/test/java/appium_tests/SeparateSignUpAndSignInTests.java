package appium_tests;

import appium_pom.LandingPage;
import appium_pom.SignUpPage;
import appium_pom.SingInPage;
import appium_util.AppiumBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SeparateSignUpAndSignInTests {
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();
    SignUpPage signUpPage  = new SignUpPage();

    @BeforeTest
    public void inti() throws MalformedURLException {
        AppiumBase appiumBase = new AppiumBase();
        appiumBase.appiumConfig();
    }

    @Test
    public void successfulSignIn() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1001308575", "123456");
    }

    @Test
    public void successfulSignUp(){
        landingPage.hitCheckMobileNumberPage();
        signUpPage.signUpSuccessfully("1124522820","Moo", "Elbanna","123456");
    }

    @AfterTest
    public void quit() {
        //  driver.quit();
    }
}



