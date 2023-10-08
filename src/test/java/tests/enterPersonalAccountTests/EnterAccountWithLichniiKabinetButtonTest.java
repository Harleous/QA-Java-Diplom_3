package tests.enterPersonalAccountTests;

import basePages.ConfigBrowser;
import clients.UserClient;
import dataProvider.CreateUser;
import dataProvider.RegFormRandomData;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthFormPage;

import static constants.ConstantUrls.STELLAR_BURGERS_HOME_PAGE;
import static constants.LocatorsAndDataConstants.CHECKOUT_OREDER_BUTTON;
import static constants.LocatorsAndDataConstants.HEADER_BUTTON_LICHNII_KABINET;

public class EnterAccountWithLichniiKabinetButtonTest {
    WebDriver driver = ConfigBrowser.startDriver();
    AuthFormPage authFormPage = new AuthFormPage(driver);
    public static String accessToken;

    @Test
    public void enterPersonalAccountTest() {

        CreateUser createUser = RegFormRandomData.getUserData();

        accessToken = UserClient.create(createUser)
                .log().all()
                .statusCode(200)
                .body("success", Matchers.equalTo(true))
                .extract().jsonPath().get("accessToken");

        driver.get(STELLAR_BURGERS_HOME_PAGE);
        driver.findElement(HEADER_BUTTON_LICHNII_KABINET).click();
        //new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(STELLAR_BURGER_LOGIN_PAGE));
        AuthFormPage.authorize(createUser);

        boolean checkoutOrderButton = driver.findElement(CHECKOUT_OREDER_BUTTON).isDisplayed();
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