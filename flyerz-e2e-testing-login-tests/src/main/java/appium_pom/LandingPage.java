package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static appium_util.AppiumBase.wait;

public class LandingPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();
    public void hitCheckMobileNumberPage(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.skip_Btn));
        appiumActions.click(locators.skip_Btn);
    }
}
