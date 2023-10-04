package appium_tests;

import appium_pom.LandingPage;
import appium_pom.SingInPage;
import appium_pom.WalletPage;
import appium_util.AppiumBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WalletTests {
    LandingPage landingPage = new LandingPage();
    SingInPage singInPage = new SingInPage();
    WalletPage walletPage = new WalletPage();

    @BeforeTest
    public void inti() throws MalformedURLException {
        AppiumBase appiumBase = new AppiumBase();
        appiumBase.appiumConfig();
    }

    @Test
    public void verifyThatUsersAreAbleToRechargeByVodafoneCash() throws InterruptedException {
        landingPage.hitCheckMobileNumberPage();
        singInPage.loginInSuccessfully("1003030921","123456");
        walletPage.rechargeByVodafoneCash("1000", "1010101010",
                "123456","123456");
    }
}
