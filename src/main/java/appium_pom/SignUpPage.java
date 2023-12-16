package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class SignUpPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void signUpSuccessfully(String phoneNumber, String firstName, String lastName, String otp) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.first_name_field));
        appiumActions.sendKeys(locators.first_name_field, firstName);
        appiumActions.sendKeys(locators.last_name_field, lastName);
        appiumActions.click(locators.save_Btn);
        Thread.sleep(5000);
//        if (appiumActions.isDisplayed(locators.close_tab_button)) {
//            wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
//            appiumActions.click(locators.close_tab_button);
//        }else{
//            System.out.println("Button is not displayed");
//        }
        wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
        appiumActions.sendKeys(locators.otp_field, otp);
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
        appiumActions.click(locators.cancel_permission_popup);
        wait.until(ExpectedConditions.elementToBeClickable(locators.closeInvitationPopup));
        appiumActions.click(locators.closeInvitationPopup);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.startYourAdd_text));
        String text = appiumActions.getText(locators.startYourAdd_text);
        Assert.assertEquals(text,
                "ابدا اعلانك الان", "users failed to login");
    }
    public void signUpForInvitation(String phoneNumber, String firstName, String lastName, String otp) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.first_name_field));
        appiumActions.sendKeys(locators.first_name_field, firstName);
        appiumActions.sendKeys(locators.last_name_field, lastName);
        appiumActions.click(locators.save_Btn);
        Thread.sleep(5000);
        if (appiumActions.isDisplayed(locators.close_tab_button)) {
            wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
            appiumActions.click(locators.close_tab_button);
        }else{
            System.out.println("Button is not displayed");
        }
        wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
        appiumActions.sendKeys(locators.otp_field, otp);
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
        appiumActions.click(locators.cancel_permission_popup);
    }

}
