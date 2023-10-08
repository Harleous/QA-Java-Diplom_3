package tests.registrationTests;

import basePages.ConfigBrowser;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
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
    public void authorizationWithWrongPasswordFails() {
        CreateUser createUser = RegFormRandomData.getUserData();

        registrationFormPage.openRegistrationPage();
        registrationFormPage.registerUser(createUser);
        driver.get(STELLAR_BURGER_LOGIN_PAGE);
        authFormPage.authWrongPassword(createUser);
        boolean wrongPassMess = driver.findElement(WRONG_PASSWORD_MESSAGE).isDisplayed();
        Assert.assertTrue(wrongPassMess);
    }
    @After
    public void quit(){
        driver.quit();
    }

}
