package pageObjects;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor extends BasePage {

    private static final By BUN_BUTTON = By.cssSelector("div.tab_tab__1SPyG:nth-child(1)");
    private static final By SOUCES_BUTTON = By.cssSelector("div.tab_tab__1SPyG:nth-child(2)");
    private static final By FILLERS_BUTTON = By.cssSelector("div.tab_tab__1SPyG:nth-child(3)");
    public Constructor(WebDriver driver) {
        super(driver);
    }
    public static String actualClassBuns =  driver.findElement(BUN_BUTTON).getAttribute("class").toString();
    public static String actualClassFillers;
    public static String getActualFillersClass(){
        actualClassFillers =
                driver.findElement(FILLERS_BUTTON).getAttribute("class").toString();
        return actualClassFillers;
    }
    public static  String actualClassSouces;
    public static String getActualSoucesClass(){
        actualClassSouces =
                driver.findElement(SOUCES_BUTTON).getAttribute("class").toString();
        return actualClassSouces;
    }
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
