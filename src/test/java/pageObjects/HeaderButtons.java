package pageObjects;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtons extends BasePage {
    public static final By HEADER_PROFILE_BUTTON = By.cssSelector("a.AppHeader_header__link__3D_hX:nth-child(3) > p:nth-child(2)");
    public static final By HEADER_CONSTRUCTOR_BUTTON = By.cssSelector(".AppHeader_header__list__3oKJj > li:nth-child(1) > a:nth-child(1) > p:nth-child(2)");
    public static final By HEADER_LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    public HeaderButtons(WebDriver driver) {
        super(driver);
    }

    public static void clickHeaderConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
    }

    public static void clickHeaderLogoButton() {
        driver.findElement(HEADER_LOGO_BUTTON).click();

    }

    public static void clickProfileButton() {
        driver.findElement(HEADER_PROFILE_BUTTON).click();
    }
}
