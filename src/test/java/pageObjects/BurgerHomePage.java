package pageObjects;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.ConstantUrls.STELLAR_BURGERS_HOME_PAGE;

public class BurgerHomePage extends BasePage {
    //ДОМАШНЯЯ СТРАНИЦА
    //кнопка «Войти в аккаунт»
    private static final By enterAccountButton = By.xpath(".//section[2]//button[text() = 'Войти в аккаунт']");
    //кнопка «Личный кабинет»
    public BurgerHomePage(WebDriver driver) {
        super(driver);
    }

    public static void openHomePage() {
        driver.get(STELLAR_BURGERS_HOME_PAGE);
    }

    public static void enterAccountButtonClick() {
        driver.findElement(enterAccountButton).click();
    }


}
