package tests.constructor;

import base.pages.ConfigBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static constants.LocatorsAndDataConstants.CHOSEN_BUTTON_CLASS_CONTAINS_STRING;
import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.Constructor.*;

public class FillersLinkTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Проверка работы перехода к разделу Начинка в Конструкторе")
    public void switchToFillersTest() {

        openHomePage();
        clickFillersButton();
        getActualFillersClass();
        Assert.assertTrue(actualClassFillers.contains(CHOSEN_BUTTON_CLASS_CONTAINS_STRING));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
