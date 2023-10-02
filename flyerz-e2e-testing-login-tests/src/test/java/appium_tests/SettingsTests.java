package appium_tests;

import appium_pom.LandingPage;
import appium_pom.SettingsPage;
import appium_pom.SingInPage;
import appium_util.AppiumActions;
import appium_util.AppiumBase;
import appium_util.Locators;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SettingsTests {
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();
    SettingsPage settingsPage = new SettingsPage();

    @BeforeTest
    public void init() throws MalformedURLException {
        AppiumBase appiumBase = new AppiumBase();
        appiumBase.appiumConfig();
    }
    @Test
    public void successfulEditName() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1001308575","123456");
        settingsPage.editFirstNameAndLastName("Ali","Ahmed");
    }
    @Test
    public void successfulEditEmail() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        settingsPage.editEmail("test@test.com");
    }
    @Test
    public void updatePhoneNumberWithAnExistingPhoneNumber() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        settingsPage.updatePhoneNumber("1016467532","123456");
    }
    @Test
    public void checkThatPhoneNumberDisplayedSuccessfully() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        Assert.assertEquals("1003030921", settingsPage.checkPhoneNumberField(), "Phone number isn't as entered");
    }
    @Test
    public void changePageSuccessfully() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        settingsPage.changeFbPage();
    }
}
