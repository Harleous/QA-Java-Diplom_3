package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtons extends BasePage {
    public static final By HEADER_BUTTON_LICHNII_KABINET = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");

    public HeaderButtons(WebDriver driver) {
        super(driver);
    }

    public static void enterLoginPageWithLichniiKabinetButton(){
    driver.findElement(HEADER_BUTTON_LICHNII_KABINET).click();
}}
