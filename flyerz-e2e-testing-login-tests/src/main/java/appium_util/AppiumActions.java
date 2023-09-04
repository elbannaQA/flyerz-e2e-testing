package appium_util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppiumActions extends AppiumBase {
    public AppiumActions() {

    }

    public void click(By path) {
        WebElement click = driver.findElement(path);
        click.click();
    }

    public void sendKeys(By path, String text) {
        WebElement sendKeys = driver.findElement(path);
        sendKeys.sendKeys(text);
    }

    public void clearText(By path) {
        WebElement clearText = driver.findElement(path);
        clearText.clear();
    }

    public String getText(By path) {
        WebElement GetText = driver.findElement(path);
        return GetText.getText();
    }

    public boolean isDisplayed(By path) {
        WebElement isDisplayed = driver.findElement(path);
        return isDisplayed.isDisplayed();
    }
}
