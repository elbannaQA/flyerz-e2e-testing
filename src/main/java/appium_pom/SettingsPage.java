package appium_pom;

import appium_util.AppiumActions;
import appium_util.AppiumBase;
import appium_util.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static appium_util.AppiumBase.wait;

public class SettingsPage{
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void editFirstNameAndLastName(String firstName, String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.first_name_field));
        appiumActions.clearText(locators.first_name_field);
        appiumActions.sendKeys(locators.first_name_field, firstName);
        appiumActions.clearText(locators.last_name_field);
        appiumActions.sendKeys(locators.last_name_field, lastName);
        String expectedResult = String.format("%s %s",
                appiumActions.getText(locators.first_name_field), appiumActions.getText(locators.last_name_field));
        System.out.println(expectedResult);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.name_text));
        String actualResult = appiumActions.getText(locators.name_text);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Name is changed successfully");
    }
    public void editEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.email_field));
        appiumActions.clearText(locators.email_field);
        appiumActions.sendKeys(locators.email_field, email);
        String expectedResult = appiumActions.getText(locators.email_field);
        System.out.println(expectedResult);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        String actualResult = appiumActions.getText(locators.email_field);
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult, "Email didn't change successfully");
    }
    public void updatePhoneNumber(String phoneNumber, String otp){
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.updatePhoneNumber_btn));
        appiumActions.click(locators.updatePhoneNumber_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.phone_number_text_field));
        appiumActions.clearText(locators.phone_number_text_field);
        appiumActions.sendKeys(locators.phone_number_text_field,phoneNumber);
        appiumActions.click(locators.next_Btn);
//        wait.until(ExpectedConditions.elementToBeClickable(locators.close_tab_button));
//        appiumActions.click(locators.close_tab_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.otp_field));
        appiumActions.sendKeys(locators.otp_field, "123456");
        appiumActions.click(locators.confirm_Btn);
        String actualResult = appiumActions.getText(locators.validation_msg);
        String expectedResult = "تم التحقق من الرقم مع مستخدم آخر !";

        Assert.assertEquals(actualResult,expectedResult, "Number is updated successfully" );
    }
    public String checkPhoneNumberField(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.editProfile_button));
        appiumActions.click(locators.editProfile_button);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.phone_number_text_field));
        String expectedResult = appiumActions.getText(locators.phone_number_text_field);
        System.out.println(expectedResult);
        return expectedResult;
    }
    public void changeFbPage() throws InterruptedException {
        appiumActions.click(locators.settings_button);
        appiumActions.click(locators.myAccounts_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.pageName_txt));
        String selectedPage_txt = appiumActions.getText(locators.pageName_txt).trim();
        System.out.println( "The Selected Page is: "+ selectedPage_txt);
        appiumActions.click(locators.changePage_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.pageNames_txt));
        List<WebElement> pageNames = appiumActions.findElements(locators.pageNames_txt);
        for (WebElement name:pageNames){
            String text = name.getText();
            System.out.println("Names of pages are: " + text);
            if (!text.equals(selectedPage_txt) ){
                wait.until(ExpectedConditions.elementToBeClickable(locators.selectPage_btn));
               appiumActions.click(locators.selectPage_btn);
                String actualResult = appiumActions.getText(locators.pageNames_txt).trim();
                System.out.println(actualResult);
                appiumActions.click(locators.next_Btn);
                wait.until(ExpectedConditions.elementToBeClickable(locators.selectCategory_btn));
                appiumActions.findElements(locators.selectCategory_btn).get(0).click();
                appiumActions.click(locators.next_Btn);
                Thread.sleep(7000);
                String expectedResult = appiumActions.getText(locators.pageName_txt).trim();
                System.out.println(expectedResult);

                Assert.assertEquals(actualResult, expectedResult, "Page didn't change");

            }
        }
//        wait.until(ExpectedConditions.elementToBeClickable(locators.selectPage_btn));
//        appiumActions.findElements(locators.selectPage_btn).get(1).click();
//        String actualResult = appiumActions.getText(locators.pageNames_txt).trim();
//        System.out.println(actualResult);
//        appiumActions.click(locators.next_Btn);
//        wait.until(ExpectedConditions.elementToBeClickable(locators.selectCategory_btn));
//        appiumActions.findElements(locators.selectCategory_btn).get(0).click();
//        appiumActions.click(locators.next_Btn);
//        Thread.sleep(7000);
//        String expectedResult = appiumActions.getText(locators.pageName_txt).trim();
//        System.out.println(expectedResult);
//
//        Assert.assertEquals(actualResult, expectedResult, "Page didn't change");
    }
    public void changeInvitationCode(String invitationCode){
        wait.until(ExpectedConditions.elementToBeClickable(locators.settings_button));
        appiumActions.click(locators.settings_button);
        wait.until(ExpectedConditions.elementToBeClickable(locators.earnMoneyTab));
        appiumActions.click(locators.earnMoneyTab);
        wait.until(ExpectedConditions.elementToBeClickable(locators.changeCodeBtn));
        appiumActions.click(locators.changeCodeBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.invitationCodeField));
        appiumActions.clearText(locators.invitationCodeField);
        appiumActions.sendKeys(locators.invitationCodeField, invitationCode);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.invitationCodeTxt));
        String expectedResult = appiumActions.getText(locators.invitationCodeTxt);
        System.out.println(expectedResult);

        Assert.assertEquals(invitationCode,expectedResult, "Invitation Code didn't change successfully");
    }
}
