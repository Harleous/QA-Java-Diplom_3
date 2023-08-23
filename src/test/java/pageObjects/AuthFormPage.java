package pageObjects;

import basePages.BasePage;
import dataProvider.CreateClient;
import dataProvider.LoginClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthFormPage extends BasePage {
    public AuthFormPage(WebDriver driver) {
        super(driver);
    }
    //ФОРМА АВТОРИЗАЦИИ
    //кнопка  "Восстановить пароль"
    private final By passwordRecoveryFormEnterButton = By.xpath(".//div/p/a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By registrationButtonInAUthForm = By.xpath(".//div/p[1]/a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    private final By authFormEmail = By.xpath("//input[@name='name']");
    private final By authFormPass = By.xpath("//input[@name='Пароль']");
    private final By EnterButtonInAuthForm = By.xpath("//button[contains(text(),'Войти')]");

public void authorize(CreateClient createClient){

    LoginClient loginClient = LoginClient.fromCreateClientData(createClient);

    driver.findElement(authFormEmail).click();
    driver.findElement(authFormEmail).sendKeys(loginClient.getEmail());

    driver.findElement(authFormPass).sendKeys(loginClient.getPassword());

    driver.findElement(EnterButtonInAuthForm).click();

}
}
