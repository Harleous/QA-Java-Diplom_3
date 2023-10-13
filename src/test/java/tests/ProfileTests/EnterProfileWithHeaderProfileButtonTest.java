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
import static pageObjects.AuthFormPage.openLoginPage;
import static pageObjects.HeaderButtons.clickProfileButton;
import static pageObjects.RegistrationFormPage.openRegistrationPage;
import static pageObjects.RegistrationFormPage.registerUser;

public class EnterProfileWithHeaderProfileButtonTest {
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    public static String accessToken;

    @Test
    public void enterPersonalAccountTest() {

        CreateUser createUser = RegFormRandomData.getUserData();
        accessToken = UserClient.create(createUser).extract().jsonPath().get("accessToken");

        openRegistrationPage();
        registerUser(createUser);
        openLoginPage();
        AuthFormPage.authorize(createUser);
        clickProfileButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(PROFILE_PAGE));

        Assert.assertEquals(PROFILE_PAGE, driver.getCurrentUrl());
    }
    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            UserClient.delete(accessToken).log().all().statusCode(202);
        }
    }
}
