package anh_edu;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
        MobileElement userIconElement = driver.findElement(MobileBy.AccessibilityId("userIcon"));
        userIconElement.click();

        // Fill up login form
        MobileElement emailInputElement = driver.findElement(MobileBy.AccessibilityId("emailInput"));
        MobileElement passwordInputElement = driver.findElement(MobileBy.AccessibilityId("passwordInput"));
        MobileElement loginElement = driver.findElement(MobileBy.AccessibilityId("loginBtn"));
        emailInputElement.sendKeys("teo@sth.com");
        passwordInputElement.sendKeys("12345678");
        driver.findElement(MobileBy.AccessibilityId("sdetpro-ecommerce")).click();
        loginElement.click();


        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.AccessibilityId("signOutBtn")));
        // Go back to home page
        driver.findElement(MobileBy.AccessibilityId("homeIcon")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}