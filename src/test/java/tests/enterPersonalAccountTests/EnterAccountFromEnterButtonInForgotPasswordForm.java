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

import static constants.LocatorsAndDataConstants.CHECKOUT_ORDER_BUTTON;
import static pageObjects.ForgotPasswordPage.clickEnterButtonInFogrotPasswordForm;
import static pageObjects.ForgotPasswordPage.openForgotPasswordPage;

public class EnterAccountFromEnterButtonInForgotPasswordForm {
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


        openForgotPasswordPage();
        clickEnterButtonInFogrotPasswordForm();
        AuthFormPage.authorize(createUser);

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
