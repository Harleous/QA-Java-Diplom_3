package tests.enterPersonalAccountTests;

import basePages.ConfigBrowser;
import clients.UserClient;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;
import pageObjects.BurgerHomePage;

import static constants.ConstantUrls.STELLAR_BURGERS_HOME_PAGE;
import static constants.LocatorsAndDataConstants.CHECKOUT_ORDER_BUTTON;
import static pageObjects.AuthFormPage.authorize;

public class EnterPersonalAccountTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void enterPersonalAccountTest() {

        CreateUser createUser = RegFormRandomData.getUserData();
        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        driver.get(STELLAR_BURGERS_HOME_PAGE);
        BurgerHomePage.enterAccountButtonClick();
        authorize(createUser);

        boolean checkoutOrderButton = driver.findElement(CHECKOUT_ORDER_BUTTON).isDisplayed();
        Assert.assertTrue(checkoutOrderButton);
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            UserClient.delete(accessToken).log().all().statusCode(202);
        }
    }
}
