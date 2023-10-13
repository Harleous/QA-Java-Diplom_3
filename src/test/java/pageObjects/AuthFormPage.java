package pageObjects;

import basePages.BasePage;
import dataProvider.CreateUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.ConstantUrls.STELLAR_BURGER_LOGIN_PAGE;
import static constants.LocatorsAndDataConstants.WRONG_PASSWORD;
import static constants.LocatorsAndDataConstants.WRONG_PASSWORD_MESSAGE;

public class AuthFormPage extends BasePage {

    //поле Name формы авторизации
    private static final By authFormEmail = By.xpath("//input[@name='name']");
    //поле Email формы авторизации
    private static final By authFormPass = By.xpath("//input[@name='Пароль']");
    //поле Password формы авторизации
    private static final By EnterButtonInAuthForm = By.xpath("//button[contains(text(),'Войти')]");
    //ФОРМА АВТОРИЗАЦИИ
    //кнопка  "Восстановить пароль"
    private final By passwordRecoveryFormEnterButton = By.xpath(".//div/p/a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By registrationButtonInAUthForm = By.xpath(".//div/p[1]/a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    //message при введении некорректного пароля
    private final By wrongPasswordMessage = WRONG_PASSWORD_MESSAGE;

    public AuthFormPage(WebDriver driver) {
        super(driver);
    }

    public static void openLoginPage() {
        driver.get(STELLAR_BURGER_LOGIN_PAGE);
    }

    public static void authorize(CreateUser createUser) {

        String email = createUser.getEmail();
        String password = createUser.getPassword();

        driver.findElement(authFormEmail).sendKeys(email);
        driver.findElement(authFormPass).sendKeys(password);
        driver.findElement(EnterButtonInAuthForm).click();
    }

    public void authWrongPassword(CreateUser createUser) {

        String email = createUser.getEmail();
        String password = WRONG_PASSWORD;

        driver.findElement(authFormEmail).sendKeys(email);

        driver.findElement(authFormPass).sendKeys(password);

        driver.findElement(EnterButtonInAuthForm).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(WRONG_PASSWORD_MESSAGE));


    }
}
