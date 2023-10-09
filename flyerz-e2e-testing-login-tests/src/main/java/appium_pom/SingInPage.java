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
    int maxRetries = 5;
    int retryInterval = 1000; // 1 second
    boolean elementClickable = false;

    public void loginInSuccessfully(String phoneNumber, String otp) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.sendKeys(locators.phone_number_text_field, phoneNumber);
        appiumActions.click(locators.next_Btn);

        for (int i = 0; i < maxRetries; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
                elementClickable = true;
                break; // If the element becomes clickable, exit the loop
            } catch (TimeoutException e) {
                System.out.println(e);
            }
            // Sleep for a short interval before retrying
            Thread.sleep(retryInterval);
        }

        if (elementClickable) {
            appiumActions.click(locators.close_tab_button);
        } else if(appiumActions.isDisplayed(locators.close_tab_button)){
            wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
            appiumActions.click(locators.close_tab_button);
        }
            wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
            appiumActions.sendKeys(locators.otp_field, otp);
            wait.until(ExpectedConditions.elementToBeClickable(locators.confirm_Btn));
            appiumActions.click(locators.confirm_Btn);
            wait.until(ExpectedConditions.elementToBeClickable(locators.cancel_permission_popup));
            appiumActions.click(locators.cancel_permission_popup);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.welcome_message));
            Assert.assertEquals(appiumActions.getText(locators.welcome_message),
                    "اهلآ بيك في فلايرز", "users failed to login");

    }

}
