package appium_tests;

import appium_pom.LandingPage;
import appium_pom.SettingsPage;
import appium_pom.SingInPage;
import appium_util.AppiumBase;
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
    public void successfulEditProfile() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        settingsPage.editProfile("Emy");
    }
}
