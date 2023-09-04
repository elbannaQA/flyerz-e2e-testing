package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class SignUpPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void signUpSuccessfully(String phoneNumber, String firstName, String lastName, String otp){
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.first_name_field));
        appiumActions.sendKeys(locators.first_name_field, firstName);
        appiumActions.sendKeys(locators.last_name_field, lastName);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
        if (appiumActions.isDisplayed(locators.close_tab_button)) {
            appiumActions.click(locators.close_tab_button);
        }
        wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
        appiumActions.sendKeys(locators.otp_field, otp);
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
        appiumActions.click(locators.cancel_permission_popup);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.welcome_message));
        String text = appiumActions.getText(locators.welcome_message);
        Assert.assertEquals(text,
                "اهلآ بيك في فلايرز", "users failed to login");
    }

}
