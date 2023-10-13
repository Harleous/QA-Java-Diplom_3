package tests.ConstructorTests;

import basePages.ConfigBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.Constructor.*;

public class SoucesTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Проверка работы перехода к разделу Соусы в Конструкторе")
    public void enterPersonalAccountTest() {

        openHomePage();
        clickSoucesButton();
        String actualClass = driver.findElement(SOUCES_BUTTON).getAttribute("class");
        Assert.assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
