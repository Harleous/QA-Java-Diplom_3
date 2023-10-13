package tests.ConstructorTests;

import basePages.ConfigBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AuthFormPage;

import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.Constructor.*;

public class BunLinkTest {
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    public static String accessToken;

    @Test
    @DisplayName("Проверка работы перехода к разделу Булка в конструкторе")
    public void enterPersonalAccountTest() {


        openHomePage();
        clickSoucesButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(SOUCES_BUTTON, "class", "tab_tab_type_current__2BEPc"));
        clickBunButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(BUN_BUTTON, "class", "tab_tab_type_current__2BEPc"));
        String actualClass =  driver.findElement(BUN_BUTTON).getAttribute("class").toString();
        Assert.assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
