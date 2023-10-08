package tests.registrationTests;

import basePages.ConfigBrowser;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.ConstantUrls.STELLAR_BURGER_LOGIN_PAGE;
import static pageObjects.RegistrationFormPage.openRegistrationPage;
import static pageObjects.RegistrationFormPage.registerUser;

public class RegistrationFlowTest extends ConfigBrowser {
    WebDriver driver = ConfigBrowser.startDriver();



@Test
    public void registrationFlowOpensAuthorizationPageTest(){


    CreateUser createUser = RegFormRandomData.getUserData();

    openRegistrationPage();
    registerUser(createUser);
    new  WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(STELLAR_BURGER_LOGIN_PAGE));

    Assert.assertEquals(  STELLAR_BURGER_LOGIN_PAGE, driver.getCurrentUrl());

}
@After
    public void quit(){
    driver.quit();
}
}
