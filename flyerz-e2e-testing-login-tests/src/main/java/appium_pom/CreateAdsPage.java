package appium_pom;

import appium_util.AppiumActions;
import appium_util.AppiumBase;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class CreateAdsPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void createAdSuccessfully(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAd_btn));
        appiumActions.click(locators.createAd_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAds_nextBtn));
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.select_adsGoal));
        appiumActions.click(locators.select_adsGoal);
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.select_post_btn));
        appiumActions.click(locators.select_post_btn);
        String actualResult = appiumActions.getText(locators.select_post_btn);
        System.out.println(actualResult);
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAds_nextBtn));
        appiumActions.click(locators.createAds_nextBtn);
        appiumActions.click(locators.createAds_nextBtn);
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.selectCountry_ddl));
        appiumActions.click(locators.selectCountry_ddl);
        appiumActions.click(locators.selectCountry_btn);
        appiumActions.click(locators.save_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.selectCities_ddl));
        appiumActions.click(locators.selectCities_ddl);
        appiumActions.click(locators.selectCities_btn);
        appiumActions.click(locators.save_Btn);
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.budget_txt));
        appiumActions.sendKeys(locators.budget_txt,"350");
        String actualResult_1 = appiumActions.getText(locators.budget_txt) +" "+ appiumActions.getText(locators.currency_sign);
        System.out.println(actualResult_1);
        appiumActions.click(locators.createAds_nextBtn);
        appiumActions.click(locators.createAds_nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.back_to_homePage_btn));
        appiumActions.click(locators.back_to_homePage_btn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.adTxt));
        String expectedResult = appiumActions.getText(locators.adTxt);
        System.out.println(expectedResult);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.adBudget));
        String expectedResult_1 = appiumActions.getText(locators.adBudget);
        System.out.println(expectedResult_1);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.adStatus));
        String actualResult_2 = appiumActions.getText(locators.adStatus);
        System.out.println(actualResult_2);
        String expectedResult_2 = "قيد المراجعة";


        Assert.assertEquals(actualResult,expectedResult,"Ad didn't Create");
        Assert.assertEquals(actualResult_1,expectedResult_1,"Ad didn't Create");
        Assert.assertEquals(actualResult_2,expectedResult_2, "Ad didn't Create");


    }
}
