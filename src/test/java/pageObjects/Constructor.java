package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor extends BasePage {
    public Constructor(WebDriver driver) {
        super(driver);
    }

    public static final By BUN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    public static final By SOUCES_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    public static final By FILLERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    public static final By ACTIVATED_BUN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public static final By ACTIVATED_SOUCES_BUTTON = By.className("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    public static final By ACTIVATED_FILLERS_BUTTON = By.className("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");


    public static void clickBunButton() {
        driver.findElement(BUN_BUTTON).click();
    }

    public static void clickSoucesButton() {
        driver.findElement(SOUCES_BUTTON).click();
    }

    public static void clickFillersButton() {
        driver.findElement(FILLERS_BUTTON).click();
    }
}
