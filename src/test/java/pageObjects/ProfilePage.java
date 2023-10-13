package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public static final By LOGOUT_BUTTON_IN_PROFILE = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public static void logOut() {
        driver.findElement(LOGOUT_BUTTON_IN_PROFILE).click();
    }
}
