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
    //кнопка "Войти"
    private final By EnterButtonInAuthForm = By.xpath(".//form/button [text() = 'Войти']");
    //кнопка  "Восстановить пароль"
    private final By passwordRecoveryFormEnterButton = By.xpath(".//div/p/a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //кнопка "Зарегистрироваться"
    private final By registrationButtonInAUthForm = By.xpath(".//div/p[1]/a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
private final By authFormName = By.xpath(".//fieldset[1]//input");
private final By authFormPass = By.xpath(".//fieldset[2]//input");

public void authorize(){
    CreateClient createClient = new CreateClient();
    LoginClient loginClient = LoginClient.fromCreateClientData(createClient);

    driver.findElement(authFormName).sendKeys(loginClient.getEmail());
    driver.findElement(authFormPass).sendKeys(loginClient.getPassword());
    driver.findElement(EnterButtonInAuthForm).click();

}
}
