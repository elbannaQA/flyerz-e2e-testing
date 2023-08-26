package pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class SingInPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();
    public void loginInSuccessfully(String phoneNumber, String otp) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);
        Thread.sleep(4000);
        appiumActions.sendKeys(locators.otp_field, otp);
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
        appiumActions.click(locators.cancel_permission_popup);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.welcome_message));
        Assert.assertEquals(appiumActions.getText(locators.welcome_message),
                "اهلآ بيك في فلايرز", "users failed to login");
    }
}