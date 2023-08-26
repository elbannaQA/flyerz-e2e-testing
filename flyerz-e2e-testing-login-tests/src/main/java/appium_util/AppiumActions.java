package appium_util;

import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppiumActions extends AppiumBase{
    public AppiumActions(){

    }
    public void click(By path){
        WebElement click = driver.findElement(path);
        click.click();
    }

    public void sendKeys(By path, String text){
        WebElement sendKeys = driver.findElement(path);
        sendKeys.sendKeys(text);
    }

    public String getText(By path){
        WebElement GetText = driver.findElement(path);
        return GetText.getText();
    }
}
