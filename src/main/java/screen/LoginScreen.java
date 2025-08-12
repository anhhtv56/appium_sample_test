package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.ElementHelper;

public class LoginScreen {
    private final AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        ElementHelper.getElement(this.driver,"userIcon").click();
        ElementHelper.getElement(this.driver,"emailInput").sendKeys(email);
        ElementHelper.getElement(this.driver, "passwordInput").sendKeys(password);
        ElementHelper.getElement(this.driver, "sdetpro-ecommerce").click();
        ElementHelper.getElement(this.driver, "loginBtn").click();
    }
}
