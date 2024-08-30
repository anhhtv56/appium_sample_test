package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static AppiumDriver<MobileElement> getAndroidDriver(String udid){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("udid", udid); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.tuhuynh.sdetproecommerce");
        caps.setCapability("appActivity", "host.exp.exponent.MainActivity");
        AppiumDriver<MobileElement> driver;
        try {
            URL appiumServerPath = new URL("http://127.0.0.1:4723");
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
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "16.4");
        caps.setCapability("deviceName", "iPhone 14 Pro Max");
        caps.setCapability("bundleId", "com.tuhuynh.sdetproecommerce");
        caps.setCapability("appActivity", "host.exp.exponent.MainActivity");
        AppiumDriver<MobileElement> driver;
        try {
            URL appiumServerPath = new URL("http://127.0.0.1:4723");
            driver = new IOSDriver<>(appiumServerPath, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR: could not create appium session");
        }
        return driver;
    }
}
