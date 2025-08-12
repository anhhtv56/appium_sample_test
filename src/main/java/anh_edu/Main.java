package anh_edu;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screen.LoginScreen;

public class Main {
    public static void main(String[] args){
        //testOnAndroid("emulator-5554");
        testOnIOS();
    }

    private static void testOnIOS(){
        AppiumDriver<MobileElement> driver = DriverFactory.getIOSDriver();
        testSteps(driver);
    }

    private static void testOnAndroid(String udid){
        AppiumDriver<MobileElement> driver = DriverFactory.getAndroidDriver(udid);
        testSteps(driver);
    }

    private static void testSteps(AppiumDriver<MobileElement> driver){
        // Use LoginScreen page object for login
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login("teo@sth.com", "12345678");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.AccessibilityId("signOutBtn")));
        // Go back to home page
        driver.findElement(MobileBy.AccessibilityId("homeIcon")).click();
    }
}