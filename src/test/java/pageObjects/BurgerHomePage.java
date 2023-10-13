package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.ConstantUrls.STELLAR_BURGERS_HOME_PAGE;

public class BurgerHomePage extends BasePage {
    public BurgerHomePage(WebDriver driver) {
        super(driver);
    }

    //ДОМАШНЯЯ СТРАНИЦА
    //кнопка «Войти в аккаунт»
    private static final By enterAccountButton = By.xpath(".//section[2]//button[text() = 'Войти в аккаунт']");
    //кнопка «Личный кабинет»
    private static final By personalAccountButton = By.cssSelector("a.AppHeader_header__link__3D_hX:nth-child(3) > p:nth-child(2)");

    public static void openHomePage() {
        driver.get(STELLAR_BURGERS_HOME_PAGE);
    }

    public static void enterAccountButtonClick() {
        driver.findElement(enterAccountButton).click();
    }


}
