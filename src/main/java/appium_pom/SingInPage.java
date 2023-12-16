package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class SingInPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void loginInSuccessfully(String phoneNumber, String otp){
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
        appiumActions.sendKeys(locators.otp_field, otp);
        wait.until(ExpectedConditions.elementToBeClickable(locators.confirm_Btn));
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.allowNotificationBtn));
        appiumActions.click(locators.allowNotificationBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
        appiumActions.click(locators.cancel_permission_popup);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.startYourAdd_text));
        Assert.assertEquals(appiumActions.getText(locators.startYourAdd_text),
                "ابدا اعلانك الان", "users failed to login");

    }

}
