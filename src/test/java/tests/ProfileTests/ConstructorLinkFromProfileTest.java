package tests.ProfileTests;

import basePages.ConfigBrowser;
import clients.UserClient;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AuthFormPage;

import static constants.ConstantUrls.PROFILE_PAGE;
import static constants.LocatorsAndDataConstants.CHECKOUT_ORDER_BUTTON;
import static pageObjects.AuthFormPage.openLoginPage;
import static pageObjects.HeaderButtons.clickHeaderConstructorButton;
import static pageObjects.HeaderButtons.clickProfileButton;

public class ConstructorLinkFromProfileTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void enterPersonalAccountTest() {

        CreateUser createUser = RegFormRandomData.getUserData();
        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        openLoginPage();
        AuthFormPage.authorize(createUser);
        clickProfileButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(PROFILE_PAGE));
        clickHeaderConstructorButton();

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
