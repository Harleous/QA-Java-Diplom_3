package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtons extends BasePage {
    public static final By HEADER_PROFILE_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");

    public HeaderButtons(WebDriver driver) {
        super(driver);
    }

    public static void clickProfileButton(){
    driver.findElement(HEADER_PROFILE_BUTTON).click();
}}
