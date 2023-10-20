package tests.registration;

import base.pages.ConfigBrowser;
import data.provider.CreateUser;
import data.provider.RegFormRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.RegistrationFormPage;

import static constants.ConstantUrls.STELLAR_BURGER_LOGIN_PAGE;
import static pageObjects.RegistrationFormPage.openRegistrationPage;
import static pageObjects.RegistrationFormPage.registerUser;

public class RegistrationFlowTest  {
    WebDriver driver = ConfigBrowser.startDriver();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registrationFlowOpensAuthorizationPageTest() {

        CreateUser createUser = RegFormRandomData.getUserData();

        openRegistrationPage();
        registerUser(createUser);
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(STELLAR_BURGER_LOGIN_PAGE));

        Assert.assertEquals(STELLAR_BURGER_LOGIN_PAGE, driver.getCurrentUrl());
    }

    @After
    public void quit() {
        driver.quit();
    }
}
