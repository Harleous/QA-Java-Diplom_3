package pageObjects;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public static final By LOGOUT_BUTTON_IN_PROFILE = By.cssSelector(".Account_button__14Yp3");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public static void logOut() {
        driver.findElement(LOGOUT_BUTTON_IN_PROFILE).click();
    }
}
