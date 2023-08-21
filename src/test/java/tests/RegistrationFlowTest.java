package tests;

import basePages.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;
import pageObjects.RegistrationFormPage;

import java.util.concurrent.TimeUnit;

public class RegistrationFlowTest extends BaseTest {
    WebDriver driver = BaseTest.startDriver();
RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
AuthFormPage authFormPage = new AuthFormPage(driver);

@Test
    public void registrationFlowOpensAuthorizationPageTest(){
    registrationFormPage.openRegistrationPage();
    registrationFormPage.registerClient();
    driver.manage().timeouts().pageLoadTimeout(10000,
            TimeUnit.MILLISECONDS);
    authFormPage.authorize();

}
/*@After
    public void quit(){
    driver.quit();
}*/
}
