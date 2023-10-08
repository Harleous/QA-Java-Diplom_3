package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtons extends BasePage {
    public HeaderButtons(WebDriver driver) {
        super(driver);
    }
    public static final By HEADER_PROFILE_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
public static final By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
   public static final By HEADER_LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
public static void clickHeaderConstructorButton(){
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
}
public static void clickHeaderLogoButton(){
    driver.findElement(HEADER_LOGO_BUTTON).click();

}
    public static void clickProfileButton(){
    driver.findElement(HEADER_PROFILE_BUTTON).click();
}}
