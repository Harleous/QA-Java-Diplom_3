package tests.enter.account;

import base.pages.ConfigBrowser;
import clients.UserClient;
import data.provider.CreateUser;
import data.provider.RegFormRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static constants.LocatorsAndDataConstants.CHECKOUT_ORDER_BUTTON;
import static pageObjects.BurgerHomePage.openHomePage;
import static pageObjects.HeaderButtons.clickProfileButton;

public class EnterAccountWithLichniiKabinetButtonTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void enterPersonalAccountWithProfileButtonTest() {

        CreateUser createUser = RegFormRandomData.getUserData();
        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        openHomePage();
        clickProfileButton();
        AuthFormPage.authorize(createUser);

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