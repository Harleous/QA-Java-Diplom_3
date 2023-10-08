package tests.ConstructorTests;

import basePages.ConfigBrowser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.Constructor.*;

public class SoucesTest {
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    public static String accessToken;

    @Test
    public void enterPersonalAccountTest() {



        openHomePage();
        clickSoucesButton();
        String actualClass = driver.findElement(SOUCES_BUTTON).getAttribute("class").toString();
        Assert.assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));

    }
    @After
    public void tearDown() {
        driver.quit();

    }
}
