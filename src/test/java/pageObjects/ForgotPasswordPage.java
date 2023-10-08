package pageObjects;

import basePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.ConstantUrls.FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    public static final By ENTER_ACCOUNT_BUTTON_IN_FORGOT_PASSWORD_FORM = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public static void openForgotPasswordPage(){
        driver.get(FORGOT_PASSWORD_PAGE);
    }
    public static void clickEnterButtonInFogrotPasswordForm(){
        driver.findElement(ENTER_ACCOUNT_BUTTON_IN_FORGOT_PASSWORD_FORM).click();
    }

}
