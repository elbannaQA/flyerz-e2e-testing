package appium_util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {
    static AppiumDriver driver;
    static DesiredCapabilities caps;
    public static WebDriverWait wait;
    public AppiumBase(){

    }

    public AppiumDriver appiumConfig() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\Administrator\\Downloads\\app-debug.apk");
        URL url = new URL("http://0.0.0.0:4723");
        driver = new AppiumDriver(url, caps);
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        return driver;
    }
}
