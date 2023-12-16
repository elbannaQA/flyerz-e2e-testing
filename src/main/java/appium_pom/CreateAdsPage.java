package appium_pom;

import appium_util.AppiumActions;
import appium_util.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static appium_util.AppiumBase.wait;

public class CreateAdsPage {
    AppiumActions appiumActions = new AppiumActions();
    Locators locators = new Locators();

    public void createdAdPageLikes(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAd_btn));
        appiumActions.click(locators.createAd_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.continue_btn));
        appiumActions.click(locators.continue_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.fb_channel_btn));
        appiumActions.click(locators.fb_channel_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.page_likes_goal));
        appiumActions.click(locators.page_likes_goal);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.select_post_btn));
        appiumActions.click(locators.select_post_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.create_ad_btn));
        appiumActions.click(locators.create_ad_btn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.successful_message_create_ads_txt));
        String actualResult = appiumActions.getText(locators.successful_message_create_ads_txt);
        Assert.assertEquals(actualResult,"تم انشاء اعلانك بنجاح", "Ad hasn't been created");

    }
    public void createAdPostEngagement(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAd_btn));
        appiumActions.click(locators.createAd_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.continue_btn));
        appiumActions.click(locators.continue_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.fb_channel_btn));
        appiumActions.click(locators.fb_channel_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.post_engagement_goal));
        appiumActions.click(locators.post_engagement_goal);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.select_post_btn));
        appiumActions.click(locators.select_post_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.create_ad_btn));
        appiumActions.click(locators.create_ad_btn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.successful_message_create_ads_txt));
        String actualResult = appiumActions.getText(locators.successful_message_create_ads_txt);
        Assert.assertEquals(actualResult,"تم انشاء اعلانك بنجاح", "Ad hasn't been created");

    }
    public void createAdMessages(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.createAd_btn));
        appiumActions.click(locators.createAd_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.continue_btn));
        appiumActions.click(locators.continue_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.fb_channel_btn));
        appiumActions.click(locators.fb_channel_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.messages_goal));
        appiumActions.click(locators.messages_goal);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.select_post_btn));
        appiumActions.click(locators.select_post_btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.next_Btn));
        appiumActions.click(locators.next_Btn);
        wait.until(ExpectedConditions.elementToBeClickable(locators.create_ad_btn));
        appiumActions.click(locators.create_ad_btn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.successful_message_create_ads_txt));
        String actualResult = appiumActions.getText(locators.successful_message_create_ads_txt);
        Assert.assertEquals(actualResult,"تم انشاء اعلانك بنجاح", "Ad hasn't been created");

    }
}
