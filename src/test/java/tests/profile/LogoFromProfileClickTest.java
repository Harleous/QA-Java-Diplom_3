package tests.profile;

import base.pages.ConfigBrowser;
import clients.UserClient;
import data.provider.CreateUser;
import data.provider.RegFormRandomData;
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
import static pageObjects.AuthFormPage.authorize;
import static pageObjects.AuthFormPage.openLoginPage;
import static pageObjects.HeaderButtons.clickHeaderLogoButton;
import static pageObjects.HeaderButtons.clickProfileButton;

public class LogoFromProfileClickTest {
    public static String accessToken;
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void clickLogoFromProfileTest() {

        CreateUser createUser = RegFormRandomData.getUserData();
        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        openLoginPage();
        authorize(createUser);
        clickProfileButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(PROFILE_PAGE));
        clickHeaderLogoButton();

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
