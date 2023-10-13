package tests.constructor;

import base.pages.ConfigBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.Constructor.FILLERS_BUTTON;
import static pageObjects.Constructor.clickFillersButton;

public class FillersTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Проверка работы перехода к разделу Начинка в Конструкторе")
    public void enterPersonalAccountTest() {

        openHomePage();
        clickFillersButton();
        String actualClass = driver.findElement(FILLERS_BUTTON).getAttribute("class");
        Assert.assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
