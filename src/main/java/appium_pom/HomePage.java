package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class HomePage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void useInvitationCode(String invitationCode){
        wait.until(ExpectedConditions.elementToBeClickable(locators.enterInvitationCodeField));
        appiumActions.sendKeys(locators.enterInvitationCodeField,invitationCode);
        wait.until(ExpectedConditions.elementToBeClickable(locators.useBtn));
        appiumActions.click(locators.useBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.codeSuccessMsg));
        String actualResult = appiumActions.getText(locators.codeSuccessMsg);
        String expectedResult = "مبروك!! سوف تحصل علي 150 ج.م بعد انشاء الحملة الاعلانية الاولى.";

        Assert.assertEquals(actualResult,expectedResult, "Code isn't valid");
    }
}
