package tests.registration;

import base.pages.ConfigBrowser;
import data.provider.CreateUser;
import data.provider.RegFormRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;
import pageObjects.RegistrationFormPage;

import static constants.ConstantUrls.STELLAR_BURGER_LOGIN_PAGE;
import static constants.LocatorsAndDataConstants.WRONG_PASSWORD_MESSAGE;

public class AuthorizationWrongPasswordTest {

    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);

    @Test
    @DisplayName("Авторизация с неправильным паролем")
    public void authorizationWithWrongPasswordFails() {
        CreateUser createUser = RegFormRandomData.getUserData();

        RegistrationFormPage.openRegistrationPage();
        RegistrationFormPage.registerUser(createUser);
        driver.get(STELLAR_BURGER_LOGIN_PAGE);
        authFormPage.authWrongPassword(createUser);

        boolean wrongPassMess = driver.findElement(WRONG_PASSWORD_MESSAGE).isDisplayed();
        Assert.assertTrue(wrongPassMess);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
