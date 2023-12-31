package appium_tests;

import appium_pom.CreateAdsPage;
import appium_pom.LandingPage;
import appium_pom.SingInPage;
import appium_util.AppiumBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CreateAds {
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();
    CreateAdsPage createAdsPage = new CreateAdsPage();
    @BeforeTest
    public void inti() throws MalformedURLException {
        AppiumBase appiumBase = new AppiumBase();
        appiumBase.appiumConfig(); }

    @Test
    public void checkThatCreateAdPageLikes(){
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        createAdsPage.createdAdPageLikes();
    }
    @Test
    public void checkThatCreateAdPostEngagement(){
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        createAdsPage.createAdPostEngagement();
    }
    @Test
    public void checkThatCreateAdMessages9oi (){
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        createAdsPage.createAdMessages();
    }

}
