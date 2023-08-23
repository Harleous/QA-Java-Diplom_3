package tests;

import basePages.BaseTest;
import dataProvider.CreateClient;
import dataProvider.RegFormRandomData;
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
    CreateClient createClient = RegFormRandomData.randomClientData();

    registrationFormPage.openRegistrationPage();
    registrationFormPage.registerClient(createClient);
    driver.manage().timeouts().pageLoadTimeout(10000,
            TimeUnit.MILLISECONDS);
    authFormPage.authorize(createClient);

}
/*@After
    public void quit(){
    driver.quit();
}*/
}
