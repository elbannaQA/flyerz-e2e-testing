package appium_tests;
import appium_util.AppiumBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.LandingPage;
import pom.SingInPage;

import java.net.MalformedURLException;

public class SignInTests{
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();

   @BeforeTest
   public void inti() throws MalformedURLException {
       AppiumBase appiumBase = new AppiumBase();
       appiumBase.appiumConfig();
   }

    @Test
    public void successfulSignIn() throws InterruptedException {
       landingPage.hitCheckMobileNumberPage();
       singInPage.loginInSuccessfully("1003030921", "123456");
    }
    @AfterClass
    public void quit(){
      //  driver.quit();
    }
}



