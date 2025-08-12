package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import utils.ConfigHelper;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AppiumDriver<MobileElement> getAndroidDriver(String udid){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", ConfigHelper.get("android.automationName"));
        caps.setCapability("udid", udid);
        caps.setCapability("platformName", ConfigHelper.get("android.platformName"));
        caps.setCapability("appPackage", ConfigHelper.get("android.appPackage"));
        caps.setCapability("appActivity", ConfigHelper.get("android.appActivity"));
        AppiumDriver<MobileElement> driver;
        try {
            URL appiumServerPath = new URL(ConfigHelper.get("appium.serverUrl"));
            driver = new AppiumDriver<>(appiumServerPath, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR: could not create appium session");
        }
        return driver;
    }

    public static AppiumDriver<MobileElement> getIOSDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", ConfigHelper.get("ios.automationName"));
        caps.setCapability("platformName", ConfigHelper.get("ios.platformName"));
        caps.setCapability("platformVersion", ConfigHelper.get("ios.platformVersion"));
        caps.setCapability("deviceName", ConfigHelper.get("ios.deviceName"));
        caps.setCapability("bundleId", ConfigHelper.get("ios.bundleId"));
        AppiumDriver<MobileElement> driver;
        try {
            URL appiumServerPath = new URL(ConfigHelper.get("appium.serverUrl"));
            driver = new IOSDriver<>(appiumServerPath, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR: could not create appium session");
        }
        return driver;
    }
}