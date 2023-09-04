package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class SettingsPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void editProfile(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.first_name_field));
        appiumActions.clearText(locators.first_name_field);
        appiumActions.sendKeys(locators.first_name_field, firstName);
        String expectedResult = String.format("%s %s",
                appiumActions.getText(locators.first_name_field), appiumActions.getText(locators.last_name_field));
        System.out.println(expectedResult);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.name_text));
        String actualResult = appiumActions.getText(locators.name_text);
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult, "Name is changed successfully");
    }
}
