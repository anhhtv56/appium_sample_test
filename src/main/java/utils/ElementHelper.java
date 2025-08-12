package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ElementHelper {
    public static MobileElement getElement(AppiumDriver<MobileElement> driver, String id) {
        return driver.findElement(MobileBy.AccessibilityId(id));
    }
}