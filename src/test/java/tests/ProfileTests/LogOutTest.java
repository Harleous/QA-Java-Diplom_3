package tests.ProfileTests;

import basePages.ConfigBrowser;
import clients.UserClient;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AuthFormPage;

import static constants.ConstantUrls.PROFILE_PAGE;
import static constants.ConstantUrls.STELLAR_BURGER_LOGIN_PAGE;
import static pageObjects.AuthFormPage.authorize;
import static pageObjects.AuthFormPage.openLoginPage;
import static pageObjects.HeaderButtons.clickProfileButton;
import static pageObjects.ProfilePage.logOut;

public class LogOutTest {
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    public static String accessToken;

    @Test
    public void enterPersonalAccountTest() {

        CreateUser createUser = RegFormRandomData.getUserData();

        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        openLoginPage();
        authorize(createUser);
        clickProfileButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(PROFILE_PAGE));
        logOut();
        new  WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(STELLAR_BURGER_LOGIN_PAGE));

        Assert.assertEquals(  STELLAR_BURGER_LOGIN_PAGE, driver.getCurrentUrl());

    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            UserClient.delete(accessToken).log().all().statusCode(202);
        }

    }
}
