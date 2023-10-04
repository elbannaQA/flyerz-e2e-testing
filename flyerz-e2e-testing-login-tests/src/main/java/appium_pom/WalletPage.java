package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class WalletPage {

    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void rechargeByVodafoneCash(String rechargeValue, String phoneNumber, String userPin, String userOtp){
        wait.until(ExpectedConditions.elementToBeClickable(locators.walletBtn));
        appiumActions.click(locators.walletBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.addBalanceBtn));
        appiumActions.click(locators.addBalanceBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.budget_txt));
        appiumActions.clearText(locators.budget_txt);
        appiumActions.sendKeys(locators.budget_txt, rechargeValue);
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.selectVodafoneCash));
        appiumActions.click(locators.selectVodafoneCash);
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.clearText(locators.phone_number_text_field);
        appiumActions.sendKeys(locators.phone_number_text_field,phoneNumber);
        appiumActions.click(locators.confirm_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.userPinTxt));
        appiumActions.sendKeys(locators.userPinTxt,userPin);
        appiumActions.sendKeys(locators.userOtpTxt, userOtp);
        appiumActions.click(locators.payBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.successPaymentMessageTxt));
        String actualResult = appiumActions.getText(locators.successPaymentMessageTxt);
        String expectedResult = "تم عملية الدفع بنجاح";

        Assert.assertEquals(actualResult, expectedResult, "Recharge wallet is failed");
        wait.until(ExpectedConditions.elementToBeClickable(locators.okBtn));
        appiumActions.click(locators.okBtn);
    }

}
